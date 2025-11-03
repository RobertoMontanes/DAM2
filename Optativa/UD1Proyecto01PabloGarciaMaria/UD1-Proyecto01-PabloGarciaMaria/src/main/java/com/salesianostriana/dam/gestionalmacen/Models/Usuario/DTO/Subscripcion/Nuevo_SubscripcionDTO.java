package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Nuevo_SubscripcionDTO {

    private long id;
    private String nombre;
    private double precio;
    private int numAlmacenes;
    private boolean soportePrioritario;
    private int duracionMeses;


}
