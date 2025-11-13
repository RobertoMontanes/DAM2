package com.salesianostriana.dam.gestionsuscripciones.Repositories;

import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
