package com.salesianostriana.dam.gestionalmacen.Repositories.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen,Long> {
}
