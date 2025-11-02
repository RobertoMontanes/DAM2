package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.ListarSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.NuevaSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubscripcionService extends BaseServiceImpl<Subscripcion, Long, SubscripcionRepository> {

    public ResponseEntity<ApiResponse<NuevaSubscripcion_SubscripcionDTO>> obtenerPlantilla() { // C
        NuevaSubscripcion_SubscripcionDTO plantilla = new NuevaSubscripcion_SubscripcionDTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));
    }

    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> crear(NuevaSubscripcion_SubscripcionDTO s) { // C
        Subscripcion newSub = s.fromDTO();
        repository.save(newSub);
        log.info("Subscripción creado: {}", newSub.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ListarSubscripcion_SubscripcionDTO.toDTO(newSub)));
    }

    public ResponseEntity<ApiResponse<List<ListarSubscripcion_SubscripcionDTO>>> listar() { // R
        List<ListarSubscripcion_SubscripcionDTO> subscripciones = repository.findAll().stream()
                .map(ListarSubscripcion_SubscripcionDTO::toDTO)
                .toList();

        return ResponseEntity.ok(ApiResponse.success(subscripciones));
    }

    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> actualizar(ListarSubscripcion_SubscripcionDTO subscripcionDTO) {
        Subscripcion s;
        Optional<Subscripcion> sOrg = repository.findById(subscripcionDTO.getId());
        if (sOrg.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Subscripción no encontrado"));
        }
        s = repository.save(sOrg.get().modify(subscripcionDTO.fromDTO()));
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(ListarSubscripcion_SubscripcionDTO.toDTO(s)));
    }

    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> eliminar(long id) { // D
        return repository.findById(id)
                .map(s -> {
                    repository.delete(s);
                    log.info("Subscripción eliminada: {}", s.getNombre());
                    ListarSubscripcion_SubscripcionDTO dto = ListarSubscripcion_SubscripcionDTO.toDTO(s);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Subscripción no encontrado")));
    }



}
