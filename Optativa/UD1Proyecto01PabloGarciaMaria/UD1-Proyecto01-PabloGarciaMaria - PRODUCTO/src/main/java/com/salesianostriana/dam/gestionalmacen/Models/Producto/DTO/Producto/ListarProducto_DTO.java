package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.Almacen.ListarAlmacen_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote.ListarLote_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private String usuarioNombre;
    private ListarAlmacen_DTO almacen;
    private List<ListarLote_DTO> lotes;

    public static ListarProducto_DTO toDTO(Producto p) {
        return ListarProducto_DTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .cantidad(p.getCantidad())
                .peso(p.getPeso())
                .usuarioNombre(p.getUsuario().getNombre())
                .categoriaProducto(p.getCategoriaProducto().name())
                .almacen(null)
                .lotes(new ArrayList<>())
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
