package com.salesianostriana.dam.monumentos.modelos;

import com.salesianostriana.dam.monumentos.errores.Monumento;

public record MonumentoResponse(
        Long id,
        String isoCode,
        String pais,
        String localizacion,
        String nombre,
        String descripcion,
        String url
) {

    public static MonumentoResponse of(Monumento monumento) {
        return new MonumentoResponse(
                monumento.getId(),
                monumento.getIsoCode(),
                monumento.getPais(),
                monumento.getLocalizacion(),
                monumento.getNombre(),
                monumento.getDescripcion(),
                monumento.getUrl()
        );
    }
}
