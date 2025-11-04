package com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Enums.EstadosAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.TipoAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class Listar_AlmacenDTO {

    private Long id;
    private String nombre;
    private String ubicacion;
    private double superficie;
    private boolean seguridad;
    private EstadosAlmacen estadoAlmacen;
    private String usuario;
    private Long tipoAlmacen;

    public static Listar_AlmacenDTO toDTO(Almacen almacen) {
        return Listar_AlmacenDTO.builder()
                .id(almacen.getId())
                .nombre(almacen.getNombre())
                .ubicacion(almacen.getUbicacion())
                .superficie(almacen.getSuperficie())
                .seguridad(almacen.isSeguridad())
                .estadoAlmacen(almacen.getEstadoAlmacen())
                .usuario(almacen.getUsuario() != null ? almacen.getUsuario().getNombre() : null)
                .tipoAlmacen(almacen.getTipoAlmacen() != null ? almacen.getTipoAlmacen().getId() : null)
                .build();
    }
}