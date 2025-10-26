package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioSubscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @ToString.Exclude
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "subscripcion_id")
    @ToString.Exclude
    private Subscripcion subscripcion;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private boolean activa;

}
