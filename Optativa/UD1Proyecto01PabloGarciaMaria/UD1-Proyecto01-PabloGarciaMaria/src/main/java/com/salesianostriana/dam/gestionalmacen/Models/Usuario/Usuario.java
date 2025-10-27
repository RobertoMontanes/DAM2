package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_username",columnNames = "username"),
                @UniqueConstraint(name = "uk_id",columnNames = "id"),
                @UniqueConstraint(name = "uk_email",columnNames = "email")
        }
)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    private String password;
    private LocalDate fechaCreacion;
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
