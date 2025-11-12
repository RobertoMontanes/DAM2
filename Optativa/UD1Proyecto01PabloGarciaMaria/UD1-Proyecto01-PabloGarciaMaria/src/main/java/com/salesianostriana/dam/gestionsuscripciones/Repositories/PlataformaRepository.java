package com.salesianostriana.dam.gestionsuscripciones.Repositories;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {
}
