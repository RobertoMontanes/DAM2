package com.salesianostriana.dam.gestionalmacen.Models.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;
    private String nombre;
    private String email;
    private String username;
    private String password;
    private LocalDate fechaCreacion;
    private boolean activo;

    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    private List<Almacen> almacenesAsignados = new ArrayList<>();
    @OneToMany(mappedBy = "usuario")
    @Builder.Default
    private List<UsuarioSubscripcion> historialSubscripciones = new ArrayList<>();

}
