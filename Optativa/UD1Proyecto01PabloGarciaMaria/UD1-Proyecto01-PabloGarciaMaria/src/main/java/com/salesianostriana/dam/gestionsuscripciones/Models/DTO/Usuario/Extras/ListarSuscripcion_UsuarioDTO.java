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
    private Double precio;
    private String fechaInicio;
    private String fechaFin;
    private Boolean autoRenovacion;


    public static ListarSuscripcion_UsuarioDTO toDTO(Suscripcion s) {
        return ListarSuscripcion_UsuarioDTO.builder()
                .id(s.getId())
                .precio(s.getPlan().getPrecio())
                .plataformaNombre(s.getPlan().getPlataforma().getNombre())
                .fechaInicio(s.getFechaInicio().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .fechaFin(s.getFechaFin().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .autoRenovacion(s.isRenovacionAutomatica())
                .build();
    }

}
