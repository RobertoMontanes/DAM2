package com.salesianostriana.dam.gestionalmacen.Models.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String nombre;
    private int cantidad;
    private double peso;
    private CategoriaProducto categoriaProducto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

    @OneToMany(mappedBy = "producto")
    @ToString.Exclude
    private List<LotesProductos> lotes;

    public Producto modify(Producto producto) {
        return Producto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .cantidad(producto.getCantidad())
                .peso(producto.getPeso())
                .categoriaProducto(producto.getCategoriaProducto())
                .almacen(producto.getAlmacen())
                .lotes(producto.getLotes())
                .build();
    }
}
