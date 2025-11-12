package com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import com.salesianostriana.dam.gestionsuscripciones.Services.Usuario.UsuarioService;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    private Estado estado;

    private LocalDate fechaCreacion;
    private LocalDateTime ultimaConexion;

    public Usuario modify(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        return this;
    }

    public void cambiarEstado() {
        this.estado = this.estado == Estado.ACTIVO ? Estado.INACTIVO : Estado.ACTIVO;
    }
}
