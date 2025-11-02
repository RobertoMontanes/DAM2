package com.salesianostriana.dam.gestionalmacen.Controllers.API.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.ListarMembresia_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.NuevoMembresia_DTO;
import com.salesianostriana.dam.gestionalmacen.Services.API.Usuario.MembresiaService;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/membresia")
public class MembresiaController {

    private final MembresiaService service;


    // ✅ C - Obtener plantilla vacía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevoMembresia_DTO>> obtenerPlantilla() {
        log.info("Obteniendo plantilla de usuario");
        return service.obtenerPlantilla();
    }

    // ✅ C - Crear subscripcion
    @PostMapping
    public ResponseEntity<ApiResponse<ListarMembresia_DTO>> crear(
            @RequestBody NuevoMembresia_DTO m) {
        log.info("Solicitud de creación de membresia: Usuario ID: {}, Subscripcion ID: {}", m.getUsuarioId(), m.getSubscripcionId());
        return service.crear(m);
    }

    // ✅ R - Listar subscripciones
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarMembresia_DTO>>> listar() {
        log.info("Listando todas las membresias");
        return service.listar();
    }

    // ✅ U - Actualizar subscripcion
    @PutMapping
    public ResponseEntity<ApiResponse<ListarMembresia_DTO>> actualizar(
            @RequestBody ListarMembresia_DTO subscripcionDTO) {
        log.info("Actualizando subscripcion con id: {}", subscripcionDTO.getId());
        return service.actualizar(subscripcionDTO);
    }

    // ✅ D - Eliminar subscripcion
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ListarMembresia_DTO>> eliminar(
            @PathVariable long id) {
        log.info("Eliminando usuario con id: {}", id);
        return service.eliminar(id);
    }

}
