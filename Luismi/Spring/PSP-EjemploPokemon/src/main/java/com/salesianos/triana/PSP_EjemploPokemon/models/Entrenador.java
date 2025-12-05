package com.salesianos.triana.PSP_EjemploPokemon.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

public class Entrenador {

    @Id @GeneratedValue
    private Long id;

    private String nombre;
    private double pokedolares;

    @OneToMany
    private Set<Pokemon> pokemons;

}
