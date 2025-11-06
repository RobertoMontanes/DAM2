package com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.TipoAlmacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.TipoAlmacen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Data
public class Listar_TipoAlmacenDTO {

    private long id;
    private String nombre;
    private double capacidad;
    private String categoria;
    private double temperatura;
    private String requisitosEspeciales;

    public static Listar_TipoAlmacenDTO toDTO(TipoAlmacen tipoAlmacen) {
        return Listar_TipoAlmacenDTO.builder()
                .id(tipoAlmacen.getId())
                .nombre(tipoAlmacen.getNombre())
                .capacidad(tipoAlmacen.getCapacidad())
                .categoria(tipoAlmacen.getCategoria().name())
                .temperatura(tipoAlmacen.getTemperatura())
                .requisitosEspeciales(tipoAlmacen.getRequisitosEspeciales())
                .build();
    }

}
