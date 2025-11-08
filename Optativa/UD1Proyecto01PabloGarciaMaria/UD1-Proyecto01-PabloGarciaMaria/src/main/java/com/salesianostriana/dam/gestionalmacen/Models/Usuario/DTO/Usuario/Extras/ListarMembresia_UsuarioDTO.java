package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Extras;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ListarMembresia_UsuarioDTO {

    private Long id;
    private String nombre;

    public static ListarMembresia_UsuarioDTO toDTO(Membresia first) {
        return ListarMembresia_UsuarioDTO.builder()
                .id(first.getId())
                .nombre(first.getSubscripcion().getNombre())
                .build();
    }
}

