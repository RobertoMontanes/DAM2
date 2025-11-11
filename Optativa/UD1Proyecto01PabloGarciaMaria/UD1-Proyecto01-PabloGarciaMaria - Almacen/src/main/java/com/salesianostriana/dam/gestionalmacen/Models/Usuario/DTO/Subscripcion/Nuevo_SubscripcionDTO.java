package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Nuevo_SubscripcionDTO {

    private long id;
    private String nombre;
    private double precio;
    private int numAlmacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    public static Nuevo_SubscripcionDTO toDTO(Subscripcion s) {

        return Nuevo_SubscripcionDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .precio(s.getPrecio())
                .numAlmacenes(s.getNumAlmacenes())
                .soportePrioritario(s.isSoportePrioritario())
                .duracionMeses(s.getDuracionMeses())
                .build();
    }


    public Subscripcion fromDTO() {
        return Subscripcion.builder()
                .id(this.id)
                .nombre(this.nombre)
                .precio(this.precio)
                .numAlmacenes(this.numAlmacenes)
                .soportePrioritario(this.soportePrioritario)
                .duracionMeses(this.duracionMeses)
                .build();
    }
}
