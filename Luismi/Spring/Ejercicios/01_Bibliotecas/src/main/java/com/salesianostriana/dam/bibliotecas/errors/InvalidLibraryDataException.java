package com.salesianostriana.dam.bibliotecas.errors;

import lombok.Getter;

@Getter
public class InvalidLibraryDataException extends RuntimeException {

    public InvalidLibraryDataException(String message) {
        super(message);
    }
}
