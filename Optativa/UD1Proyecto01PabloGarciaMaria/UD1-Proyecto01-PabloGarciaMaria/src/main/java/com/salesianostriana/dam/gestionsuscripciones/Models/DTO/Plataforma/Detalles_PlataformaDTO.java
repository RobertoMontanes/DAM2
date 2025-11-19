package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras.ListarPlanes_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder @AllArgsConstructor @NoArgsConstructor @Data
public class Detalles_PlataformaDTO {

    public Long id;
    public String nombre;
    public List<ListarPlanes_PlataformaDTO> planes;
    private String categoria;

    public static Detalles_PlataformaDTO toDTO(Plataforma p, List<Plan> planesLimited) {
        List<ListarPlanes_PlataformaDTO> planes = planesLimited.stream()
                .map(ListarPlanes_PlataformaDTO::toDTO)
                .toList();

        return Detalles_PlataformaDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .categoria(p.getCategoria().name())
                .planes(planes)
                .build();
    }


}
