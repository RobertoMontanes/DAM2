package com.salesianostriana.dam.gestionalmacen.Models.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Enums.EstadosAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private String nombre;
    private String ubicacion;
    private double superficie;
    private boolean seguridad;

    private EstadosAlmacen estadoAlmacen;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "tipo_almacen_id")
    private TipoAlmacen tipoAlmacen;


}
