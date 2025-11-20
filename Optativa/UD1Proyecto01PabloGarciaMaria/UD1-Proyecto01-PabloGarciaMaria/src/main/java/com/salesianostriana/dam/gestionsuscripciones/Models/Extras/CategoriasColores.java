package com.salesianostriana.dam.gestionsuscripciones.Models.Extras;

public enum CategoriasColores {
    ENTRETENIMIENTO("#f39c12"),
    EDUCACION("#27ae60"),
    DEPORTES("#e74c3c"),
    MUSICA("#9b59b6"),
    NOTICIAS("#3498db"),
    OTROS("#95a5a6");

    private final String colorHex;

    CategoriasColores(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getColorHex() {
        return colorHex;
    }
}

