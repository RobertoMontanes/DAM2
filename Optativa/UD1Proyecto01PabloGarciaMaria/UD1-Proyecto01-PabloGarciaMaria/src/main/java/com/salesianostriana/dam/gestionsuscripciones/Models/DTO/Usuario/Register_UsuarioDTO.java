package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Builder @Data

public class Register_UsuarioDTO {

    private String nombre ;
    private String apellidos ;
    private String email ;
    private String password ;

}
