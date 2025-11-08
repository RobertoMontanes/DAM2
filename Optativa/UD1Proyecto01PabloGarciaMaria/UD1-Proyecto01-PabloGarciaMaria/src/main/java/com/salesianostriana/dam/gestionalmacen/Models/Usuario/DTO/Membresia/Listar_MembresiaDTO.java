package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Listar_MembresiaDTO {

    private Long id;
    private String usuario;
    private String subscripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private boolean activa;
    private boolean cancelado;


    public static Listar_MembresiaDTO toDTO(Membresia membresia) {
        return Listar_MembresiaDTO.builder()
                .id(membresia.getId())
                .usuario(membresia.getUsuario() == null ? "Usuario eliminado" : membresia.getUsuario().getNombre() + " " + membresia.getUsuario().getApellidos())
                .subscripcion(membresia.getSubscripcion() == null ? "Subscroripción eliminada" : membresia.getSubscripcion().getNombre())
                .fechaInicio(membresia.getFechaInicio())
                .fechaFin(membresia.getFechaFin())
                .activa(membresia.isActiva())
                .cancelado(membresia.isCancelado())
                .build();
    }
}
