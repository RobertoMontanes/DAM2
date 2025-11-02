package com.salesianostriana.dam.gestionalmacen.Controllers.API.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.ListarProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.NuevoProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.ListarSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.NuevaSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.ListarUsuario_DTO;
import com.salesianostriana.dam.gestionalmacen.Services.API.Producto.ProductoService;
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
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    // ✅ C - Obtener plantilla vacía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevoProducto_DTO>> obtenerPlantilla() {
        log.info("Obteniendo plantilla de producto");
        return service.obtenerPlantilla();
    }

    // ✅ C - Crear
    @PostMapping
    public ResponseEntity<ApiResponse<ListarProducto_DTO>> crear(
            @RequestBody NuevoProducto_DTO p) {
        log.info("Solicitud de creación de producto: {}", p.getNombre());
        return service.crear(p);
    }

    // ✅ R - Listar
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarProducto_DTO>>> listar() {
        log.info("Listando todos los productos");
        return service.listar();
    }

    // ✅ U - Actualizar
    @PutMapping
    public ResponseEntity<ApiResponse<ListarProducto_DTO>> actualizar(
            @RequestBody ListarProducto_DTO productoDTO) {
        log.info("Actualizando producto con id: {}", productoDTO.getId());
        return service.actualizar(productoDTO);
    }

    // ✅ D - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ListarProducto_DTO>> eliminar(
            @PathVariable long id) {
        log.info("Eliminando producto con id: {}", id);
        return service.eliminar(id);
    }

    // EXTRAS - Obtener categorias
    @GetMapping("/categorias")
    public ResponseEntity<ApiResponse<Map<Integer,String>>> obtenerCategorias() {
        log.info("Obteniendo lista de categorias de productos");
        return service.obtenerCategorias();
    }

}
