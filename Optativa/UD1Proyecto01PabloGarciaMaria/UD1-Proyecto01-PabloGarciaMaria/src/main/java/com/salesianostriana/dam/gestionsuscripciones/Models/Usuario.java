package com.salesianostriana.dam.gestionsuscripciones.Models;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany
    private List<Plataforma> plataformas;

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

    public void addPlataforma(Plataforma p) {
        this.plataformas.add(p);
    }

    public boolean findPlataformaById(Long id) {
        for (Plataforma p : plataformas) {
            if (p.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }
}
