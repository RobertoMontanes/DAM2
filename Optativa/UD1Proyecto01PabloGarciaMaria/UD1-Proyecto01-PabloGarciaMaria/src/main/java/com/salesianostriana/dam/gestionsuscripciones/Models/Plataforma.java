package com.salesianostriana.dam.gestionsuscripciones.Models;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class Plataforma {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private Estado estado;

    @ManyToOne
    private Usuario usuario;

    public void modify(Plataforma plataforma) {
        this.nombre = plataforma.getNombre();
    }
}
