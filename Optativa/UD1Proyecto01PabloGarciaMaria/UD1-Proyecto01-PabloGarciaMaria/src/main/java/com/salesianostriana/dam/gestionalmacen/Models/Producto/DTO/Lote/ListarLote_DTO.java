package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.Accion;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Lote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListarLote_DTO {

    private long id;
    private String fechaAccion;
    private String accion;

    public static ListarLote_DTO toDTO(Lote l) {
        return ListarLote_DTO.builder()
                .id(l.getId())
                .fechaAccion(l.getFechaAccion().toString())
                .accion(l.getAccion().toString())
                .build();
    }

    public Lote fromDTO() {
        return Lote.builder()
                .id(this.id)
                .fechaAccion(LocalDate.parse(this.fechaAccion))
                .accion(Accion.valueOf(accion.toUpperCase()))
                .build();
    }
}
