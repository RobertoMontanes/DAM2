package com.salesianostriana.dam.bibliotecas.models.dtos;

import com.salesianostriana.dam.bibliotecas.models.Biblioteca;

public record ListBibliotecaResponse(
        Long id,
        String city_name,
        String library_name,
        String oficial_page_url
) {

    public static ListBibliotecaResponse of(Biblioteca b) {
        return new ListBibliotecaResponse(b.getId(), b.getCity_name(), b.getLibrary_name(), b.getOficial_page_url());
    }

}
