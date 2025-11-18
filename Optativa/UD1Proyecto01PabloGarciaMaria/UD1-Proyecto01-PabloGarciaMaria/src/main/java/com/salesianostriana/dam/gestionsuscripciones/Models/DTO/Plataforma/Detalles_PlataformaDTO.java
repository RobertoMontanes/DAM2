package com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras.ListarPlanes_PlataformaDTO;
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



}
