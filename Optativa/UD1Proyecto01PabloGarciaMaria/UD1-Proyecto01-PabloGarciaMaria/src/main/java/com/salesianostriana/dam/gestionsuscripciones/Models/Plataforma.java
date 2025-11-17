package com.salesianostriana.dam.gestionsuscripciones.Models;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter @ToString
@Table(name = "plataformas")
public class Plataforma {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private boolean estado;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "plataforma")
    @Builder.Default
    @ToString.Exclude
    private List<Plan> planes = new ArrayList<>();

    private Categorias categoria;

    public void modify(Plataforma plataforma) {
        this.nombre = plataforma.getNombre();
    }

    public void addPlan(Plan plan) {
        if (this.planes == null) {
            this.planes = new ArrayList<>();
        }
        this.planes.add(plan);
    }
}
