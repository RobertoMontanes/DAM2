package com.salesianostriana.dam.gestionsuscripciones.Models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Period;
import java.util.List;

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
    private Boolean activo;

    @ManyToOne
    private Plataforma plataforma;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plan")
    @ToString.Exclude
    private List<Suscripcion> suscripciones;

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

    public void addSuscripcion(Suscripcion s) {
        if (this.suscripciones == null) {
            this.suscripciones = new java.util.ArrayList<>();
        }
        this.suscripciones.add(s);
    }
}

