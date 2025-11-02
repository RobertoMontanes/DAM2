package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ListarProducto_DTO {

    private long id;
    private String nombre;
    private int cantidad;
    private double peso;
    private String categoriaProducto;

    public static ListarProducto_DTO toDTO(Producto p) {
        return ListarProducto_DTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .cantidad(p.getCantidad())
                .peso(p.getPeso())
                .categoriaProducto(p.getCategoriaProducto().name())
                .build();
    }

    public Producto fromDTO() {
        return Producto.builder()
                .id(this.id)
                .nombre(this.nombre)
                .cantidad(this.cantidad)
                .peso(this.peso)
                .categoriaProducto(CategoriaProducto.valueOf(this.categoriaProducto))
                .build();
    }

}
