package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
@Builder
public class NuevaSubscripcion_SubscripcionDTO {

    private String nombre;
    private double precio;
    private int numAlmacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    public static NuevaSubscripcion_SubscripcionDTO toDTO(Subscripcion subscripcion) {
        return NuevaSubscripcion_SubscripcionDTO.builder()
                .nombre(subscripcion.getNombre())
                .precio(subscripcion.getPrecio())
                .numAlmacenes(subscripcion.getNumAlmacenes())
                .soportePrioritario(subscripcion.isSoportePrioritario())
                .duracionMeses(subscripcion.getDuracionMeses())
                .build();
    }

    public Subscripcion fromDTO() {
        return Subscripcion.builder()
                .nombre(this.nombre)
                .precio(this.precio)
                .numAlmacenes(this.numAlmacenes)
                .soportePrioritario(this.soportePrioritario)
                .duracionMeses(this.duracionMeses)
                .build();
    }
}
