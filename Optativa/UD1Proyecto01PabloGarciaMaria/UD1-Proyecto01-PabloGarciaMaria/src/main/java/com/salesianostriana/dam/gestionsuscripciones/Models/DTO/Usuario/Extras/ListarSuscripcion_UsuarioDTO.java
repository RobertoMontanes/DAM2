package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ListarSuscripcion_UsuarioDTO {

    private Long id;
    private String plataformaNombre;
    private String fechaInicio;
    private String fechaFin;


    public static ListarSuscripcion_UsuarioDTO toDTO(Suscripcion s) {
        return ListarSuscripcion_UsuarioDTO.builder()
                .id(s.getId())
                .plataformaNombre(s.getPlan().getPlataforma().getNombre())
                .fechaInicio(s.getFechaInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .fechaFin(s.getFechaFin().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .build();
    }

}
