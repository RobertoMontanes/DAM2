package com.salesianostriana.dam.gestionalmacen.Models;

import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.List;

public class Usuario {

    @Id
    private long id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private LocalDate fechaCreacion;
    private boolean activo;

    private List<Almacen> almacenesAsignados;
    private List<UsuarioSubscripcion> historialSubscripciones;

}
