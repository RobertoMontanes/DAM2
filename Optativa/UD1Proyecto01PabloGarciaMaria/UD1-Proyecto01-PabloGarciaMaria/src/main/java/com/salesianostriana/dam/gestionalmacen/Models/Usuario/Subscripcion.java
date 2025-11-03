package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "subscripciones"
)
public class Subscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    private double precio;
    private int numAlmacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    @OneToMany(mappedBy = "subscripcion")
    private List<Membresia> historialUsuarios;

    public Subscripcion modify(Subscripcion subscripcion) {
        return Subscripcion.builder()
                .id(this.id)
                .nombre(subscripcion.getNombre())
                .precio(subscripcion.getPrecio())
                .numAlmacenes(subscripcion.getNumAlmacenes())
                .soportePrioritario(subscripcion.isSoportePrioritario())
                .duracionMeses(subscripcion.getDuracionMeses())
                .build();
    }
}
