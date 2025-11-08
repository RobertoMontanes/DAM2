package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Extras.ListarMembresia_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Listar_UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellidos;
    private String username;
    private String email;
    private LocalDate fechaCreacion;
    private boolean activo;
    private ListarMembresia_UsuarioDTO membresia;

    public static Listar_UsuarioDTO toDTO(Usuario usuario) {
        System.out.println(usuario.getHistorialSubscripciones());
        return Listar_UsuarioDTO.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .activo(usuario.isActivo())
                .fechaCreacion(usuario.getFechaCreacion())
                .membresia(usuario.getHistorialSubscripciones() != null && !usuario.getHistorialSubscripciones().isEmpty() ? ListarMembresia_UsuarioDTO.toDTO(usuario.getHistorialSubscripciones().stream().filter(Membresia::isActiva).toList().getFirst()) : null)
                .build();
    }

}
