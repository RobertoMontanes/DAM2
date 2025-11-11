package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class Nuevo_MembresiaDTO {

    private Long id;
    private Long usuarioId;
    private Long subscripcionId;
    private String fechaInicio = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private boolean activa = true;
    private boolean cancelado = false;


    public static Nuevo_MembresiaDTO toDTO(Membresia s) {
        return Nuevo_MembresiaDTO.builder()
                .id(s.getId())
                .usuarioId(s.getUsuario().getId())
                .subscripcionId(s.getSubscripcion().getId())
                .fechaInicio(s.getFechaInicio().toString())
                .activa(s.isActiva())
                .cancelado(s.isCancelado())
                .build();
    }
}
