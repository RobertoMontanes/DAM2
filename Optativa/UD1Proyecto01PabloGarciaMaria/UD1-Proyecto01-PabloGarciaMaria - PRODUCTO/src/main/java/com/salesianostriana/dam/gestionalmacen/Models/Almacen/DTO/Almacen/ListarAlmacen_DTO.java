package com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class ListarAlmacen_DTO {

    private long id;
    private String nombre;
    private String ubicacion;
    private double superficie;
    private boolean seguridad;
    private String estadoAlmacen;

    public static ListarAlmacen_DTO toDto(Almacen almacen) {
        return ListarAlmacen_DTO.builder()
                .id(almacen.getId())
                .nombre(almacen.getNombre())
                .ubicacion(almacen.getUbicacion())
                .superficie(almacen.getSuperficie())
                .seguridad(almacen.isSeguridad())
                .estadoAlmacen(almacen.getEstadoAlmacen().name())
                .build();
    }
}
