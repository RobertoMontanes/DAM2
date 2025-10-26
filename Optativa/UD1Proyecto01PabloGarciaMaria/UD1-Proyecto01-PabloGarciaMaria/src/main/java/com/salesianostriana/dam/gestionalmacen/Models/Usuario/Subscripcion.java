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
public class Subscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String nombre;
    private double precio;
    private int num_almacenes;
    private boolean soportePrioritario;
    private int duracionMeses;

    @OneToMany(mappedBy = "subscripcion")
    private List<UsuarioSubscripcion> historialUsuarios;

}
