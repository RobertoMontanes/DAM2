package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(
    name = "usuario",
    uniqueConstraints = {
        @UniqueConstraint(name = "uk_username_usuario",columnNames = "username"),
        @UniqueConstraint(name = "uk_id_usuario",columnNames = "id"),
        @UniqueConstraint(name = "uk_email_usuario",columnNames = "email")
        }
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "El username no puede estar vacío")
    @Size(min = 3, max = 30, message = "El username debe tener entre 3 y 30 caracteres")
    private String username;

    private String password;
    @Builder.Default
    private LocalDate fechaCreacion = LocalDate.now();
    private boolean activo;

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    private List<Almacen> almacenesAsignados = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    
    private List<UsuarioSubscripcion> historialSubscripciones = new ArrayList<>();
    
	public Usuario modify(Usuario u) {
		this.nombre = u.getNombre();
		this.email = u.getEmail();
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.fechaCreacion = u.getFechaCreacion();
		this.activo = u.isActivo();
		return this;
	}

}
