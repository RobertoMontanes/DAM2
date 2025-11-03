package com.salesianostriana.dam.gestionalmacen.Repositories.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.TipoAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAlmacenRepository extends JpaRepository<TipoAlmacen,Long> {
}
