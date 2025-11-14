package com.salesianostriana.dam.gestionsuscripciones.Repositories;

import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion,Long> {
}
