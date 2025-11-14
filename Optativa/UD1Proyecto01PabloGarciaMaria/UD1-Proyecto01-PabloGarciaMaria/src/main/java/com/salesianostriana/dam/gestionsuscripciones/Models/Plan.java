package com.salesianostriana.dam.gestionsuscripciones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Period;

@Entity
@Builder @Data @NoArgsConstructor
@AllArgsConstructor
@Table(name = "planes")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Double precio;
    private Period frecuencia;

    @ManyToOne
    private Plataforma plataforma;

    public void modify(Plan plan) {
        this.nombre = plan.getNombre();
        this.precio = plan.getPrecio();
        this.frecuencia = plan.getFrecuencia();
    }

    public Plataforma borrarPlataforma() {
        Plataforma plataformaOriginal = this.plataforma;
        this.plataforma.getPlanes().remove(this);
        this.plataforma = null;
        return plataformaOriginal;
    }
}

