package com.salesianostriana.dam.gestionalmacen.Models;

import com.salesianostriana.dam.gestionalmacen.Models.Enums.CategoriasAlmacen;
import jakarta.persistence.Id;

public class TipoAlmacen {

    @Id
    private long id;

    private String nombre;
    private double capacidad;

    private CategoriasAlmacen categoria;
    private double temperatura;

    private String requisitosEspeciales;

}
