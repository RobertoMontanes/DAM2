package com.salesianostriana.dam.bibliotecas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Year;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Biblioteca {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city_name;
    private String library_name;
    private Year foundation_year;
    private Long number_of_books;
    private String general_description;
    private String oficial_page_url;

    public Biblioteca modify(Biblioteca biblioteca) {
        return Biblioteca.builder()
                .id(this.id)
                .city_name(biblioteca.getCity_name())
                .library_name(biblioteca.getLibrary_name())
                .foundation_year(biblioteca.getFoundation_year())
                .number_of_books(biblioteca.getNumber_of_books())
                .general_description(biblioteca.getGeneral_description())
                .oficial_page_url(biblioteca.getOficial_page_url())
                .build();
    }
}
