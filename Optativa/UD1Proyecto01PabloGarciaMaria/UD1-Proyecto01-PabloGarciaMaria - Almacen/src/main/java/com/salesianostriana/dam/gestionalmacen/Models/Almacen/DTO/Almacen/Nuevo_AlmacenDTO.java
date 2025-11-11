package com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Nuevo_AlmacenDTO {

    private Long id;
    private String nombre;
    private String ubicacion;
    private double superficie;
    private boolean seguridad;
    private String estadoAlmacen;
    private Long usuarioID;
    private Long tipoAlmacenID;

    public static Nuevo_AlmacenDTO toDTO(Almacen s) {
        return Nuevo_AlmacenDTO.builder()
                .id(s.getId())
                .nombre(s.getNombre())
                .ubicacion(s.getUbicacion())
                .superficie(s.getSuperficie())
                .seguridad(s.isSeguridad())
                .estadoAlmacen(s.getEstadoAlmacen().name())
                .usuarioID(s.getUsuario() != null ? s.getUsuario().getId() : null)
                .tipoAlmacenID(s.getTipoAlmacen() != null ? s.getTipoAlmacen().getId() : null)
                .build();
    }
}
