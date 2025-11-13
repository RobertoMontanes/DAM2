package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder @AllArgsConstructor @NoArgsConstructor
public class Nuevo_PlanDTO {

    private String nombre;
    private double precio;
    private int frecuencia_dias;
    private int frecuencia_meses;
    private int frecuencia_anios;

}
