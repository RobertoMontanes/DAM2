package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.Almacen.ListarAlmacen_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NuevoProducto_DTO {

    private Integer id;
    private String nombre;
    private int cantidad;
    private double peso;
    private String categoriaProducto;
    private Long almacenID;
    private Long usuarioID;


}
