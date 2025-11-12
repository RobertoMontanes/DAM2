package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @NoArgsConstructor
@AllArgsConstructor
public class Listar_UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String estado;

    public static Listar_UsuarioDTO toDTO(Usuario usuario) {
        return Listar_UsuarioDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .email(usuario.getEmail())
                .estado(usuario.getEstado().name())
                .build();
    }

}
