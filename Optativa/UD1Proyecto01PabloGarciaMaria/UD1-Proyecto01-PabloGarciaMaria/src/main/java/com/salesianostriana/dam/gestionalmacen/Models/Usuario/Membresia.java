package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

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
    private Long id;

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

    public Membresia modify(Membresia membresia) {
        return Membresia.builder()
                .id(this.id)
                .usuario(membresia.getUsuario())
                .subscripcion(membresia.getSubscripcion())
                .fechaInicio(membresia.getFechaInicio())
                .fechaFin(membresia.getFechaFin())
                .activa(membresia.isActiva())
                .cancelado(membresia.isCancelado())
                .build();
    }

    public static boolean nonNull(Membresia m) {
        return m != null;
    }
}
