package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Period;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Editar_PlanDTO {

    private long id;
    private String nombre;
    private double precio;
    private int frecuencia_dias;
    private int frecuencia_meses;
    private int frecuencia_anios;

    public static Editar_PlanDTO toDTO(Plan plan) {
        return Editar_PlanDTO.builder()
                .id(plan.getId())
                .nombre(plan.getNombre())
                .precio(plan.getPrecio())
                .frecuencia_dias(plan.getFrecuencia().getDays())
                .frecuencia_meses(plan.getFrecuencia().getMonths())
                .frecuencia_anios(plan.getFrecuencia().getYears())
                .build();
    }

    public Plan fromDTO() {
        return Plan.builder()
                .id(this.getId())
                .nombre(this.getNombre())
                .precio(this.getPrecio())
                .frecuencia(Period.of(frecuencia_anios,frecuencia_meses,frecuencia_dias))
                .build();
    }

}
