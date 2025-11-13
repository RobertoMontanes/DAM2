package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class ListarPlanes_PlataformaDTO {

    private String nombre;
    private double precio;
    private int frecuencia_dias;
    private int frecuencia_meses;
    private int frecuencia_anios;

    public static ListarPlanes_PlataformaDTO toDTO(Plan plan) {
        return ListarPlanes_PlataformaDTO.builder()
                .nombre(plan.getNombre())
                .precio(plan.getPrecio())
                .frecuencia_dias(plan.getFrecuencia().getDays())
                .frecuencia_meses(plan.getFrecuencia().getMonths())
                .frecuencia_anios(plan.getFrecuencia().getYears())
                .build();
    }
}
