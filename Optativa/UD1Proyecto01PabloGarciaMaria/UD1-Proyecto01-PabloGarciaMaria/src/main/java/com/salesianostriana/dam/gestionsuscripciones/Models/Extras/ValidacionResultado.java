package com.salesianostriana.dam.gestionsuscripciones.Models.Extras;

import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class ValidacionResultado {

    private String redirect;
    private String error;
    private Object objeto;

    @Builder.Default
    private boolean exito = true;
}

