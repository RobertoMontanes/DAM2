package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.UsuarioSubscripcion;


import com.salesianostriana.dam.gestionalmacen.Models.Usuario.UsuarioSubscripcion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NuevoUsuarioSubscripcion_DTO {

    private long usuarioId;
    private long subscripcionId;
    @Builder.Default
    private String fechaInicio = java.time.LocalDate.now().toString();
    private boolean activa;

    public static NuevoUsuarioSubscripcion_DTO toDTO(UsuarioSubscripcion us) {
        return NuevoUsuarioSubscripcion_DTO.builder()
                .usuarioId(us.getUsuario().getId())
                .subscripcionId(us.getSubscripcion().getId())
                .fechaInicio(us.getFechaInicio().toString())
                .activa(us.isActiva())
                .build();
    }

}
