package com.salesianostriana.dam.gestionsuscripciones.Models;

import jakarta.persistence.Entity;

import java.time.Period;

@Entity
public class Plan {

    private Long id;

    private String nombre;
    private Double precio;
    private Period frecuencia;

}

