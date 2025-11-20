package com.salesianostriana.dam.bibliotecas.errors;

import lombok.Getter;

@Getter
public class NotEnoughElementsException extends RuntimeException {

    private String objectType;

    public NotEnoughElementsException(String message, String objectType) {
        super(message);
        this.objectType = objectType;
    }
    public NotEnoughElementsException() {
        super();
    }
}
