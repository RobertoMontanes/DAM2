package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "Los apellidos no puede estar vacío")
    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "El username no puede estar vacío")
    @Size(min = 3, max = 30, message = "El username debe tener entre 3 y 30 caracteres")
    private String username;

    private String password;

    @Builder.Default
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion = LocalDate.now();
    private boolean activo;

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    @ToString.Exclude
    private List<Almacen> almacenesAsignados = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    @ToString.Exclude
    private List<Membresia> historialSubscripciones = new ArrayList<>();

    public Usuario modify(Usuario usuario) {
        return Usuario.builder()
                .id(this.getId())
                .nombre(usuario.getNombre())
                .apellidos(usuario.getApellidos())
                .email(usuario.getEmail())
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .fechaCreacion(usuario.getFechaCreacion())
                .activo(usuario.isActivo())
                .almacenesAsignados(usuario.getAlmacenesAsignados())
                .historialSubscripciones(usuario.getHistorialSubscripciones())
                .build();
    }
}
