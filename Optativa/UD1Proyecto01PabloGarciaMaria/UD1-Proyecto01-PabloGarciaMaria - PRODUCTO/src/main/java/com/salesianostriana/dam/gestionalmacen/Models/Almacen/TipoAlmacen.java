package com.salesianostriana.dam.gestionalmacen.Models.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Enums.CategoriasAlmacen;
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
public class TipoAlmacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String nombre;
    private double capacidad;

    private CategoriasAlmacen categoria;
    private double temperatura;

    private String requisitosEspeciales;

    @OneToMany(mappedBy = "tipoAlmacen")
    private List<Almacen> almacenes;

}
