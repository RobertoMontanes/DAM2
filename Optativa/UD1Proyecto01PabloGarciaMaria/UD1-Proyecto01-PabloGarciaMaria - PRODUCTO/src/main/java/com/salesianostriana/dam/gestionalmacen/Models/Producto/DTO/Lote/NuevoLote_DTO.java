package com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.Accion;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Lote;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NuevoLote_DTO {

    private String fechaAccion = LocalDate.now().toString();
    private String accion;

    public Lote fromDTO() {
        return Lote.builder()
                .accion(Accion.valueOf(this.accion))
                .fechaAccion(LocalDate.parse(this.fechaAccion))
                .build();
    }

}
