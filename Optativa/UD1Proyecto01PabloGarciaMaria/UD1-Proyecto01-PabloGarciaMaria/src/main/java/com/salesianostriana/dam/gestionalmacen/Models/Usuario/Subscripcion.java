package com.salesianostriana.dam.gestionalmacen.Models;

import jakarta.persistence.Id;

import java.util.List;

public class Subscripcion {

    @Id
    private long id;
    private String nombre;
    private double precio;
    private int num_almacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    private List<UsuarioSubscripcion> historialUsuarios;

}
