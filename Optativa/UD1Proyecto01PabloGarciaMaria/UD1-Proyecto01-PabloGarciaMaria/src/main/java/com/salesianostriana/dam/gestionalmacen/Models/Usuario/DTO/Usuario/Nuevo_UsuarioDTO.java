package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Nuevo_UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String username;
    private String password;

    private String telefono;
    private String direccion;
    private String observaciones;

    @Builder.Default
    private String fechaCreacion = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    @Builder.Default
    private boolean activo = true;


    public static Nuevo_UsuarioDTO toDTO(Usuario u) {
        return Nuevo_UsuarioDTO.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .apellidos(u.getApellidos())
                .email(u.getEmail())
                .username(u.getUsername())
                .password(u.getPassword())
                .fechaCreacion(u.getFechaCreacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .activo(u.isActivo())
                .build();
    }

    public Usuario fromDTO() {
        return Usuario.builder()
                .nombre(this.nombre)
                .apellidos(this.apellidos)
                .email(this.email)
                .username(this.username)
                .password(this.password)
                .fechaCreacion(LocalDate.parse(this.fechaCreacion, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .activo(this.activo)
                .build();
    }
}
