package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Extras;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ListarMembresia_UsuarioDTO {

    private Long id;
    private String nombre;
    private boolean activa;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public static ListarMembresia_UsuarioDTO toDTO(Membresia m) {
        return ListarMembresia_UsuarioDTO.builder()
                .id(m.getId())
                .nombre(m.getSubscripcion().getNombre())
                .activa(m.isActiva())
                .fechaInicio(m.getFechaInicio())
                .fechaFin(m.getFechaFin())
                .build();
    }
}

