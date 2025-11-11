package com.salesianostriana.dam.gestionalmacen.Repositories.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscripcionRepository extends JpaRepository<Subscripcion,Long> {
}
