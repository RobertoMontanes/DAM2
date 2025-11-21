package com.salesianostriana.dam.gestionsuscripciones.Models.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FiltradoSuscripciones{

    private List<Suscripcion> suscripcionesFiltradas;
    private List<Suscripcion> suscripcionesFiltradasAnteriores;

}
