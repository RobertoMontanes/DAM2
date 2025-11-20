package com.salesianostriana.dam.bibliotecas.models.dtos;

import com.salesianostriana.dam.bibliotecas.models.Biblioteca;

import java.time.Year;

public record BibliotecaDetailsResponse(
        Long id,
        String city_name,
        String library_name,
        Year foundation_year,
        Long number_of_books,
        String general_description,
        String oficial_page_url
) {
    public static BibliotecaDetailsResponse of(Biblioteca biblioteca) {
        return new BibliotecaDetailsResponse(
                biblioteca.getId(),
                biblioteca.getCity_name(),
                biblioteca.getLibrary_name(),
                biblioteca.getFoundation_year(),
                biblioteca.getNumber_of_books(),
                biblioteca.getGeneral_description(),
                biblioteca.getOficial_page_url()
        );
    }
}
