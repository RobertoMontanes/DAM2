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
        name = "subscripciones",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_id_sub",columnNames = "id"),
                @UniqueConstraint(name = "uk_nombre_sub",columnNames = "nombre")
        }
)
public class Subscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    @Column(nullable = false)
    private String nombre;

    private double precio;
    private int num_almacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    @OneToMany(mappedBy = "subscripcion")
    private List<UsuarioSubscripcion> historialUsuarios;

    public Subscripcion modify(Subscripcion subscripcion) {
        return Subscripcion.builder()
                .id(this.id)
                .nombre(subscripcion.getNombre())
                .precio(subscripcion.getPrecio())
                .num_almacenes(subscripcion.getNum_almacenes())
                .soportePrioritario(subscripcion.isSoportePrioritario())
                .duracionMeses(subscripcion.getDuracionMeses())
                .build();
    }
}
