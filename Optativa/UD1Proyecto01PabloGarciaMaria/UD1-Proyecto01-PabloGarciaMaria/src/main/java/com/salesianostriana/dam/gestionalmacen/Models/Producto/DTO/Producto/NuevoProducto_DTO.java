package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto;

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

    private String nombre;
    private int cantidad;
    private double pesoUnitario;
    private int categoriaProducto;

    public Producto fromDTO() {
        return Producto.builder()
                .nombre(this.nombre)
                .cantidad(this.cantidad)
                .peso(this.pesoUnitario)
                .categoriaProducto(CategoriaProducto.values()[this.categoriaProducto])
                .build();

    }
}
