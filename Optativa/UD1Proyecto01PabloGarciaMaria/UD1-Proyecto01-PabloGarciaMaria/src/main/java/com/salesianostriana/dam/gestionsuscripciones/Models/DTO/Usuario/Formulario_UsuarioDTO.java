package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data @AllArgsConstructor
@NoArgsConstructor @Builder
public class Formulario_UsuarioDTO {

    private Long id;

    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    @Builder.Default
    private String fechaCreacion = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private Boolean estado;

    public static Formulario_UsuarioDTO toDTO(Usuario usuario) {
        return Formulario_UsuarioDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .email(usuario.getEmail())
                .password(usuario.getPassword())
                .fechaCreacion(usuario.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .estado(usuario.getEstado() == Estado.ACTIVO)
                .build();
    }


    public Usuario fromDTO() {
        return Usuario.builder()
                .id(this.id)
                .nombre(this.nombre)
                .apellidos(this.apellidos)
                .email(this.email)
                .password(this.password)
                .fechaCreacion(LocalDate.parse(this.fechaCreacion, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .estado(this.estado ? Estado.ACTIVO : Estado.INACTIVO)
                .ultimaConexion(null)
                .build();
    }
}
