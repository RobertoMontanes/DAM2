package com.salesianostriana.dam.bibliotecas.models.dtos;

import com.salesianostriana.dam.bibliotecas.models.Biblioteca;

import java.time.Year;

public record CreateBibliotecaRequest(
        String city_name,
        String library_name,
        int foundation_year,
        Long number_of_books,
        String general_description,
        String oficial_page_url
) {

    public Biblioteca to() {
        return Biblioteca.builder()
                .city_name(city_name)
                .library_name(library_name)
                .foundation_year(Year.of(foundation_year))
                .number_of_books(number_of_books)
                .general_description(general_description)
                .oficial_page_url(oficial_page_url)
                .build();
    }

}
