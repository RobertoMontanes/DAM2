package com.salesianostriana.dam.gestionalmacen.Models;

import jakarta.persistence.Id;

import java.time.LocalDate;

public class UsuarioSubscripcion {

    @Id
    private long id;

    private Usuario usuario;
    private Subscripcion subscripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private boolean activa;

}
