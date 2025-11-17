package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Suscripcion;

import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import jdk.jfr.Registered;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

@Data @AllArgsConstructor @RequiredArgsConstructor @Builder
public class Nuevo_SuscripcionDTO {

    private String fechaInicio = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private Long planId;
    private Long plataformaId;

    private Boolean autoRenovacion;

    public static Nuevo_SuscripcionDTO toDTO(Suscripcion s) {
        return Nuevo_SuscripcionDTO.builder()
                .fechaInicio(s.getFechaInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .planId(s.getPlan().getId())
                .autoRenovacion(s.isRenovacionAutomatica())
                .build();
    }

}
