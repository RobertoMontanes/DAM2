package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class Nuevo_MembresiaDTO {

    private Long id;
    private Long usuarioId;
    private Long subscripcionId;
    private LocalDate fechaInicio;
    private boolean activa;
    private boolean cancelado;


    public static Nuevo_MembresiaDTO toDTO(Membresia s) {
        return Nuevo_MembresiaDTO.builder()
                .id(s.getId())
                .usuarioId(s.getUsuario().getId())
                .subscripcionId(s.getSubscripcion().getId())
                .fechaInicio(s.getFechaInicio())
                .activa(s.isActiva())
                .cancelado(s.isCancelado())
                .build();
    }
}
