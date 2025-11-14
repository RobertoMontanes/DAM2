package com.salesianostriana.dam.gestionsuscripciones.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data @Builder @AllArgsConstructor
@NoArgsConstructor
public class Suscripcion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.ALL)
    private Plan plan;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private boolean activa;

}
