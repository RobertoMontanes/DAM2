package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras.NuevoPlan_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Nuevo_PlataformaDTO {

    private String nombre;
    private NuevoPlan_PlataformaDTO plan;
    private String categoria;

    private LocalDate fecha_suscripcion = null;

    public Plataforma fromDTO() {
        return Plataforma.builder()
                .id(null)
                .nombre(this.getNombre())
                .estado(true)
                .categoria(Categorias.valueOf(this.getCategoria()))
                .build();
    }
}
