package com.salesianostriana.dam.gestionsuscripciones.Models.Extras;

import lombok.*;

@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class EstadisticasPlataformaDTO {
    private String nombre;
    private Double gastoTotal;
    private Double porcentajeTotal;
    private Double gastoPromedio;
    private Integer totalSuscripciones;
    private String color;

}
