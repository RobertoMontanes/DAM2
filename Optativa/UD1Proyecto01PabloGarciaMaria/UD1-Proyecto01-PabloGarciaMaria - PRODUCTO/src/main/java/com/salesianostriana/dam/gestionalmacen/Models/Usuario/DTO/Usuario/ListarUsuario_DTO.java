package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListarUsuario_DTO {

    private long id;
    private String nombre;
    private String email;
    private String username;
    private LocalDate fechaCreacion;
    private boolean activo;

    public Usuario UsuarioDTOtoUsuario() {
        return Usuario.builder()
                .id(this.id)
                .nombre(this.nombre)
                .email(this.email)
                .username(this.username)
                .fechaCreacion(this.fechaCreacion)
                .activo(this.activo)
                .build();
    }

    public static ListarUsuario_DTO UsuarioToUsuarioDTO(Usuario usuario) {
        return ListarUsuario_DTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .email(usuario.getEmail())
                .username(usuario.getUsername())
                .fechaCreacion(usuario.getFechaCreacion())
                .activo(usuario.isActivo())
                .build();
    }

}
