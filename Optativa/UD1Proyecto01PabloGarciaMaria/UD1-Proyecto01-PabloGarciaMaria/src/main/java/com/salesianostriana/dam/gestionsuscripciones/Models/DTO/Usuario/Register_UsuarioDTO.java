package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor @Builder @Data

public class Register_UsuarioDTO {

    private String nombre ;
    private String apellidos ;
    private String email ;
    private String password ;
    private String password_confirmation ;


    public Usuario fromDTO() {
        return Usuario.builder()
                .nombre(this.nombre)
                .apellidos(this.apellidos)
                .email(this.email)
                .password(this.password)
                .estado(Estado.ACTIVO)
                .fechaCreacion(LocalDate.now())
                .ultimaConexion(LocalDateTime.now())
                .build();
    }
}
