package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListarMembresia_DTO {

    private long id;
    private long usuarioId;
    private long subscripcionId;
    private String fechaInicio;
    private String fechaFin;
    private boolean activa;
    private boolean cancelado;

    public static ListarMembresia_DTO toDTO(Membresia us) {
        return ListarMembresia_DTO.builder()
                .id(us.getId())
                .usuarioId(us.getUsuario().getId())
                .subscripcionId(us.getSubscripcion().getId())
                .fechaInicio(us.getFechaInicio().toString())
                .fechaFin(us.getFechaFin().toString())
                .activa(us.isActiva())
                .cancelado(us.isCancelado())
                .build();
    }

}
