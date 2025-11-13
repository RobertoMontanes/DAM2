package com.salesianostriana.dam.gestionsuscripciones.Models;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Data
public class Plataforma {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private boolean estado;

    @ManyToOne
    private Usuario usuario;

    @OneToMany
    @Builder.Default
    private List<Plan> planes = new ArrayList<>();

    public void modify(Plataforma plataforma) {
        this.nombre = plataforma.getNombre();
    }
}
