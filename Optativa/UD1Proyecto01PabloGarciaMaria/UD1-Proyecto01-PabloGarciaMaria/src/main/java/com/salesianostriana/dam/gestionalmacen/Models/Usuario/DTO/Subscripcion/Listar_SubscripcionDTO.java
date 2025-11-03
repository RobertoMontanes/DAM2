package com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data	
public class Listar_SubscripcionDTO {

    private long id;
    private String nombre;
    private double precio;
    private int numAlmacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    public static Listar_SubscripcionDTO toDTO(Subscripcion s) {
        return Listar_SubscripcionDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .precio(s.getPrecio())
                .numAlmacenes(s.getNumAlmacenes())
                .soportePrioritario(s.isSoportePrioritario())
                .duracionMeses(s.getDuracionMeses())
                .build();
    }
}
