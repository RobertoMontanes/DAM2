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
public class ListarUsuarioSubscripcion_DTO {

    private long id;
    private long usuarioId;
    private long subscripcionId;
    private String fechaInicio;
    private String fechaFin;
    private boolean activa;

    public static ListarUsuarioSubscripcion_DTO toDTO(UsuarioSubscripcion us) {
        return ListarUsuarioSubscripcion_DTO.builder()
                .id(us.getId())
                .usuarioId(us.getUsuario().getId())
                .subscripcionId(us.getSubscripcion().getId())
                .fechaInicio(us.getFechaInicio().toString())
                .fechaFin(us.getFechaFin().toString())
                .activa(us.isActiva())
                .build();
    }

}
