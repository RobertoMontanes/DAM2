package com.salesianostriana.dam.gestionalmacen.Controllers.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevaSubscripcion_SubscripcionDTO;
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
public class SubscripcionController    {

    private final SubscripcionService subscripcionService;


    // ✅ C - Obtener plantilla vacía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevaSubscripcion_SubscripcionDTO>> obtenerPlantillaSubscripcion() {
        log.info("Obteniendo plantilla de usuario");
        return subscripcionService.obtenerPlantillaSubscripcion();
    }

    // ✅ C - Crear usuario
    @PostMapping
    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> crearUsuario(
            @RequestBody NuevaSubscripcion_SubscripcionDTO s) {
        log.info("Solicitud de creación de subscripcion: {}", s.getNombre());
        return subscripcionService.crearSubscripcion(s);
    }

    // ✅ R - Listar usuarios
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarSubscripcion_SubscripcionDTO>>> obtenerSubscripciones() {
        log.info("Listando todas las subscripciones");
        return subscripcionService.obtenerSubscripciones();
    }

}
