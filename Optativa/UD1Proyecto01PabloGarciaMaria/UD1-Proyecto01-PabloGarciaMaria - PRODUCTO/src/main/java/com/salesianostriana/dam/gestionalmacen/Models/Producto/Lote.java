package com.salesianostriana.dam.gestionalmacen.Models.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.Accion;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Data @AllArgsConstructor
@NoArgsConstructor @Builder
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    private LocalDate fechaAccion;
    private Accion accion;

    @OneToMany(mappedBy = "lote")
    private List<LotesProductos> productos;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "almacen_id")
    private Almacen almacen;


    public Lote modify(Lote lote) {
        return Lote.builder()
                .id(lote.getId())
                .fechaAccion(lote.getFechaAccion())
                .accion(lote.getAccion())
                .almacen(lote.getAlmacen())
                .productos(lote.getProductos())
                .build();
    }
}
