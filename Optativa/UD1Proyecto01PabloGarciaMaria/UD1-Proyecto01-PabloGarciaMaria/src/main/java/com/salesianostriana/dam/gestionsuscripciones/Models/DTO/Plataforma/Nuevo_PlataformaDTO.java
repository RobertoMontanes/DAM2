package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras.NuevoPlan_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Nuevo_PlataformaDTO {

    private String nombre;
    private NuevoPlan_PlataformaDTO plan;

    public Plataforma fromDTO() {
        return Plataforma.builder()
                .id(null)
                .nombre(this.getNombre())
                .estado(Estado.ACTIVO)
                .build();
    }
}
