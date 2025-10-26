package com.salesianostriana.dam.gestionalmacen.Models.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
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
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;

    @OneToMany(mappedBy = "producto")
    private List<LotesProductos> lotes;

}
