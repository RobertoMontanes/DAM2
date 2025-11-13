package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Period;

@Builder @AllArgsConstructor @NoArgsConstructor @Data
public class Nuevo_PlanDTO {

    private String nombre;
    private double precio;
    private int frecuencia_dias;
    private int frecuencia_meses;
    private int frecuencia_anios;

    public Plan fromDTO() {
        return Plan.builder()
                .nombre(this.getNombre())
                .precio(this.getPrecio())
                .frecuencia(Period.of(frecuencia_anios,frecuencia_meses,frecuencia_dias))
                .build();
    }
}
