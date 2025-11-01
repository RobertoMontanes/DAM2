package com.salesianostriana.dam.gestionalmacen.Controllers.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.ListarSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.NuevaSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Services.API.SubscripcionService;
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
@RequestMapping("/api/subscripcion")
public class SubscripcionController {

    private final SubscripcionService service;


    // ✅ C - Obtener plantilla vacía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevaSubscripcion_SubscripcionDTO>> obtenerPlantilla() {
        log.info("Obteniendo plantilla de usuario");
        return service.obtenerPlantilla();
    }

    // ✅ C - Crear subscripcion
    @PostMapping
    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> crear(
            @RequestBody NuevaSubscripcion_SubscripcionDTO s) {
        log.info("Solicitud de creación de subscripcion: {}", s.getNombre());
        return service.crear(s);
    }

    // ✅ R - Listar subscripciones
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarSubscripcion_SubscripcionDTO>>> listar() {
        log.info("Listando todas las subscripciones");
        return service.listar();
    }

    // ✅ U - Actualizar subscripcion
    @PutMapping
    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> actualizar(
            @RequestBody ListarSubscripcion_SubscripcionDTO subscripcionDTO) {
        log.info("Actualizando subscripcion con id: {}", subscripcionDTO.getId());
        return service.actualizar(subscripcionDTO);
    }

    // ✅ D - Eliminar subscripcion
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> eliminar(
            @PathVariable long id) {
        log.info("Eliminando usuario con id: {}", id);
        return service.eliminar(id);
    }

}
