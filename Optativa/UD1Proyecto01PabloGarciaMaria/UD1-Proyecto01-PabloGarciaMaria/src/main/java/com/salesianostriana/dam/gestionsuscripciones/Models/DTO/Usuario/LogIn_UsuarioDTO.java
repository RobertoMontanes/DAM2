package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class LogIn_UsuarioDTO {

    private String email;
    private String password;

}
