package com.salesianostriana.dam.gestionalmacen.Services.API.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.ListarMembresia_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.NuevoMembresia_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.MembresiaRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MembresiaService extends BaseServiceImpl<Membresia, Long, MembresiaRepository> {

    private final SubscripcionService subscripcionService;
    private final UsuarioService usuarioService;

    public ResponseEntity<ApiResponse<NuevoMembresia_DTO>> obtenerPlantilla() { // C
        NuevoMembresia_DTO plantilla = new NuevoMembresia_DTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));
    }

    public ResponseEntity<ApiResponse<ListarMembresia_DTO>> crear(NuevoMembresia_DTO us) { // C
        Membresia newMembresia;
        Optional<Membresia> membresiaActiva;

        try {
            newMembresia = fromDTO(us);
        } catch (IllegalArgumentException e) {
            log.error("Error al crear la membresía: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        membresiaActiva = repository.findActiveByUsuario(newMembresia.getUsuario());

        log.info("Membresia activa: {}", membresiaActiva);

        if (membresiaActiva.isPresent()) {
            if (membresiaActiva.get().getFechaFin().equals(LocalDate.now())) {
                membresiaActiva.get().setActiva(false);
            } else {
                String msg = "El usuario con ID " + us.getUsuarioId() + " ya tiene una membresía activa.";
                log.warn(msg);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error(msg));
            }
        }

        repository.save(newMembresia);
        log.info("Nueva subscripción de usuario creada: Usuario {}, Subscripcion {}", newMembresia.getUsuario().getNombre(), newMembresia.getSubscripcion().getNombre());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ListarMembresia_DTO.toDTO(newMembresia)));
    }
    
    public ResponseEntity<ApiResponse<List<ListarMembresia_DTO>>> listar() {
        return ResponseEntity.ok(
                ApiResponse.success(
                        repository.findAll().stream()
                                .map(ListarMembresia_DTO::toDTO)
                                .toList()
                )
        );

    }

    public ResponseEntity<ApiResponse<ListarMembresia_DTO>> actualizar(ListarMembresia_DTO membresiaDTO) {
        // Puedes cancelar una activa pero no puedes activar una cancelada.
        Membresia m;
        Optional<Membresia> mOrg = repository.findById(membresiaDTO.getId());

        if (mOrg.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Membresía no encontrada"));
        }

        try {
            m = modify(membresiaDTO);
        } catch (IllegalArgumentException e) {
            log.error("Error al actualizar la membresía: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(e.getMessage()));
        }

        if (mOrg.get().isActiva() && !m.isActiva()) {
            if (m.getFechaFin().isAfter(LocalDate.now())) {
                m.setCancelado(true);
            }
        }

        if (m.isCancelado()) {
            m.setActiva(false);
        } else {
            m.setActiva(m.getFechaFin().isAfter(LocalDate.now()));
        }

        repository.save(m);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(ListarMembresia_DTO.toDTO(m)));
    }

    private Membresia modify(ListarMembresia_DTO membresiaDTO) {
        return Membresia.builder()
                .id(membresiaDTO.getId())
                .usuario(usuarioService.findById(membresiaDTO.getUsuarioId()).orElseThrow(() ->
                        new IllegalArgumentException("Usuario con ID " + membresiaDTO.getUsuarioId() + " no encontrado")))
                .subscripcion(subscripcionService.findById(membresiaDTO.getSubscripcionId()).orElseThrow(() ->
                        new IllegalArgumentException("Subscripción con ID " + membresiaDTO.getSubscripcionId() + " no encontrada")))
                .fechaInicio(LocalDate.parse(membresiaDTO.getFechaInicio()))
                .fechaFin(LocalDate.parse(membresiaDTO.getFechaFin()))
                .activa(membresiaDTO.isActiva())
                .cancelado(membresiaDTO.isCancelado())
                .build();
    }

    public ResponseEntity<ApiResponse<ListarMembresia_DTO>> eliminar(long id) { // D
        return repository.findById(id)
                .map(s -> {
                    repository.delete(s);
                    log.info("Membresia eliminada: {}", s.getId());
                    ListarMembresia_DTO dto = ListarMembresia_DTO.toDTO(s);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Subscripción no encontrado")));
    }

    private Membresia fromDTO(NuevoMembresia_DTO us) {
        LocalDate fechaFin;
        Usuario usuario = usuarioService.findById(us.getUsuarioId()).orElseThrow(() ->
                new IllegalArgumentException("Usuario con ID " + us.getUsuarioId() + " no encontrado"));
        Subscripcion subscripcion = subscripcionService.findById(us.getSubscripcionId()).orElseThrow(() ->
                new IllegalArgumentException("Subscripción con ID " + us.getSubscripcionId() + " no encontrada"));


        fechaFin = LocalDate.parse(us.getFechaInicio()).plusMonths(subscripcion.getDuracionMeses());

        return Membresia.builder()
                .usuario(usuario)
                .subscripcion(subscripcion)
                .fechaInicio(LocalDate.parse(us.getFechaInicio()))
                .fechaFin(fechaFin)
                .activa(fechaFin.isAfter(LocalDate.now()))
                .cancelado(false)
                .build();
    }


}


