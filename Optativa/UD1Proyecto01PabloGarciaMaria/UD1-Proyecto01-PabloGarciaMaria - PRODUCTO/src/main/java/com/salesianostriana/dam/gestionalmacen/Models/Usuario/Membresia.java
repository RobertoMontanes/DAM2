package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.ListarMembresia_DTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Membresia {

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

    @Builder.Default
    @Column(nullable = false)
    private LocalDate fechaInicio = LocalDate.now();

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private boolean activa;

    @Column(nullable = false)
    @Builder.Default
    private boolean cancelado = false;
}
