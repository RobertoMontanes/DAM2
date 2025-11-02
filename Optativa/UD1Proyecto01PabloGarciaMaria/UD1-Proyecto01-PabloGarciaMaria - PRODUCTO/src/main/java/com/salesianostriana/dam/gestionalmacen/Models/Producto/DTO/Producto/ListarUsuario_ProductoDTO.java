package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListarUsuario_ProductoDTO {

    private long id;
    private String nombre;
    private String email;

    public static ListarUsuario_ProductoDTO toDTO(Usuario u) {
        return ListarUsuario_ProductoDTO.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .email(u.getEmail())
                .build();
    }

}
