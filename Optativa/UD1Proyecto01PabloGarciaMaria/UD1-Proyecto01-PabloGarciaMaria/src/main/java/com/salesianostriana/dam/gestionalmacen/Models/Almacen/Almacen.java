package com.salesianostriana.dam.gestionalmacen.Models;

import com.salesianostriana.dam.gestionalmacen.Models.Enums.EstadosAlmacen;
import jakarta.persistence.Id;

public class Almacen {

    @Id
    private long id;

    private Usuario usuario;
    private TipoAlmacen tipoAlmacen;

    private String nombre;
    private String ubicacion;
    private EstadosAlmacen estadoAlmacen;
    private double superficie;

    private boolean seguridad;
    private List<Lote> lotes;

}
