package com.salesianostriana.dam.gestionalmacen.Services.API.Producto;

import com.salesianostriana.dam.gestionalmacen.Controllers.API.Producto.ProductoController;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.ListarProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.NuevoProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.NuevaSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Repositories.Producto.ProductoRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductoService extends BaseServiceImpl<Producto,Long, ProductoRepository> {

    public ResponseEntity<ApiResponse<NuevoProducto_DTO>> obtenerPlantilla() {
        NuevoProducto_DTO plantilla = new NuevoProducto_DTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));
    }

    public ResponseEntity<ApiResponse<ListarProducto_DTO>> crear(NuevoProducto_DTO np) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(ListarProducto_DTO.toDTO(repository.save(np.fromDTO()))));
    }

    public ResponseEntity<ApiResponse<List<ListarProducto_DTO>>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(repository.findAll().stream().map(ListarProducto_DTO::toDTO).toList()));
    }

    public ResponseEntity<ApiResponse<ListarProducto_DTO>> actualizar(ListarProducto_DTO productoDTO) {
        Producto p;
        Optional<Producto> pOrg = repository.findById(productoDTO.getId());
        if (pOrg.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Producto no encontrado"));
        }

        if (!CategoriaProducto.findByString(productoDTO.getCategoriaProducto())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Categoria no encontrado"));
        }

        if (productoDTO.getCategoriaProducto() == null) {
            productoDTO.setCategoriaProducto(String.valueOf(pOrg.get().getCategoriaProducto()));
        }

        p = repository.save(pOrg.get().modify(productoDTO.fromDTO()));
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(ListarProducto_DTO.toDTO(p)));
    }

    public ResponseEntity<ApiResponse<ListarProducto_DTO>> eliminar(long id) {
        return repository.findById(id)
                .map(p -> {
                    repository.delete(p);
                    ListarProducto_DTO dto = ListarProducto_DTO.toDTO(p);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Producto no encontrado")));
    }

    public ResponseEntity<ApiResponse<Map<Integer,String>>> obtenerCategorias() {
        return ResponseEntity.ok(ApiResponse.success(CategoriaProducto.getCategorias()));
    }
}
