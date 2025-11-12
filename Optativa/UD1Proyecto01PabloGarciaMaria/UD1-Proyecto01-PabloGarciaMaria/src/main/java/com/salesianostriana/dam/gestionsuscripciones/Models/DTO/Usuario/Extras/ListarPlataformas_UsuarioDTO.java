package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class ListarPlataformas_UsuarioDTO {

    private Long id;
    private String nombre;

    public static ListarPlataformas_UsuarioDTO toDTO(Plataforma p) {
        return ListarPlataformas_UsuarioDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .build();
    }


}
