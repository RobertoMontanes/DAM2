package com.salesianostriana.dam.gestionalmacen.Controllers.API.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote.ListarLote_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote.NuevoLote_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.ListarProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.NuevoProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Services.API.Producto.LoteService;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@Controller
@RequestMapping("/api/lote")
@RequiredArgsConstructor
public class LoteController  {

    private final LoteService service;

    // ✅ C - Obtener plantilla vacía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevoLote_DTO>> obtenerPlantilla() {
        log.info("Obteniendo plantilla de lote");
        return service.obtenerPlantilla();
    }

    // ✅ C - Crear
    @PostMapping
    public ResponseEntity<ApiResponse<ListarLote_DTO>> crear(
            @RequestBody NuevoLote_DTO l) {
        log.info("Solicitud de creación de lote");
        return service.crear(l);
    }

    // ✅ R - Listar
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarLote_DTO>>> listar() {
        log.info("Listando todos los lotes");
        return service.listar();
    }

    // ✅ U - Actualizar
    @PutMapping
    public ResponseEntity<ApiResponse<ListarLote_DTO>> actualizar(
            @RequestBody ListarLote_DTO l) {
        log.info("Actualizando lote con id: {}", l.getId());
        return service.actualizar(l);
    }

    // ✅ D - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ListarLote_DTO>> eliminar(
            @PathVariable long id) {
        log.info("Eliminando lote con id: {}", id);
        return service.eliminar(id);
    }

    // EXTRAS - Obtener acciones
    @GetMapping("/acciones")
    public ResponseEntity<ApiResponse<Map<Integer,String>>> obtenerAcctiones() {
        log.info("Obteniendo lista de acciones de Lotes");
        return service.obtenerAcctiones();
    }
}
