package com.salesianostriana.dam.gestionalmacen.Models.Producto;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
public class LotesProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "lote_id")
    private Lote lote;


}
