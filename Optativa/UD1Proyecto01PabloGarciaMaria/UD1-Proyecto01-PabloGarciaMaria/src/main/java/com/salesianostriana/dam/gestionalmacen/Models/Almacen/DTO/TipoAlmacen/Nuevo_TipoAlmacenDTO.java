package com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.TipoAlmacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Enums.CategoriasAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.TipoAlmacen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Nuevo_TipoAlmacenDTO {

    private long id;
    private String nombre;
    private double capacidad;
    private String categoria;
    private double temperatura;
    private String requisitosEspeciales;

    public static Nuevo_TipoAlmacenDTO toDTO(TipoAlmacen tipoAlmacen) {
        return Nuevo_TipoAlmacenDTO.builder()
                .id(tipoAlmacen.getId())
                .nombre(tipoAlmacen.getNombre())
                .capacidad(tipoAlmacen.getCapacidad())
                .categoria(tipoAlmacen.getCategoria().name())
                .temperatura(tipoAlmacen.getTemperatura())
                .requisitosEspeciales(tipoAlmacen.getRequisitosEspeciales())
                .build();
    }


    public TipoAlmacen fromDTO(Nuevo_TipoAlmacenDTO tipoAlmacen) {
        return TipoAlmacen.builder()
                .id(tipoAlmacen.getId())
                .nombre(tipoAlmacen.getNombre())
                .capacidad(tipoAlmacen.getCapacidad())
                .categoria(CategoriasAlmacen.valueOf(tipoAlmacen.getCategoria()))
                .temperatura(tipoAlmacen.getTemperatura())
                .requisitosEspeciales(tipoAlmacen.getRequisitosEspeciales())
                .build();
    }
}
