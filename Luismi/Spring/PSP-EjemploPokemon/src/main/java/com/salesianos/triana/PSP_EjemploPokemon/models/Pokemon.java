package com.salesianos.triana.PSP_EjemploPokemon.models;

import com.salesianos.triana.PSP_EjemploPokemon.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "pokemon"
)
public class Pokemon {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String mote;

    private int nivel;
    private double peso;
    private double altura;


    private LocalDateTime fechaCaptura;

    private Set<Tipo> tipo;

    @ManyToOne
    private Entrenador duenio;

}
