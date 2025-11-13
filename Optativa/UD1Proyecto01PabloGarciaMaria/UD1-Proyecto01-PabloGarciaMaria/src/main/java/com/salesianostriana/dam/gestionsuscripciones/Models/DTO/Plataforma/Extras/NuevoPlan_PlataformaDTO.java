package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class NuevoPlan_PlataformaDTO {

    private String nombre = "Por defecto";
    private double precio;
    private int frecuencia_dias;
    private int frecuencia_meses;
    private int frecuencia_anios;

    public Plan fromDTO() {
        return Plan.builder()
                .nombre(this.getNombre())
                .precio(this.getPrecio())
                .frecuencia(Period.of(this.getFrecuencia_anios(),
                        this.getFrecuencia_meses(),
                        this.getFrecuencia_dias()))
                .build();
    }
}
