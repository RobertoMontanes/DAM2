package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Formulario_PlataformaDTO {

    private Long id;
    private String nombre;
    private String categoria;

    public Plataforma fromDTO() {
        return Plataforma.builder()
                .id(this.getId())
                .nombre(this.getNombre())
                .estado(true)
                .categoria(Categorias.valueOf(this.getCategoria()))
                .build();
    }
}
