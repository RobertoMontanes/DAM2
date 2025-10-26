package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class NuevoUsuario_UsuarioDTO {

    private String nombre;
    private String email;
    private String username;
    private String password;
    private boolean activo;

    public Usuario UsuarioDTOtoUsuario() {
        return Usuario.builder()
                .nombre(this.nombre)
                .email(this.email)
                .username(this.username)
                .password(this.password)
                .fechaCreacion(LocalDate.now())
                .activo(this.activo)
                .build();
    }


}
