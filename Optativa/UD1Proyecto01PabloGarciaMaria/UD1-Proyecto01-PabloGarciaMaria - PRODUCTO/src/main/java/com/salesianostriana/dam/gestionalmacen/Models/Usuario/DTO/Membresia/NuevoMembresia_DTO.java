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
public class NuevoMembresia_DTO {

    private long usuarioId;
    private long subscripcionId;
    @Builder.Default
    private String fechaInicio = java.time.LocalDate.now().toString();

    public static NuevoMembresia_DTO toDTO(Membresia us) {
        return NuevoMembresia_DTO.builder()
                .usuarioId(us.getUsuario().getId())
                .subscripcionId(us.getSubscripcion().getId())
                .fechaInicio(us.getFechaInicio().toString())
                .build();
    }

}
