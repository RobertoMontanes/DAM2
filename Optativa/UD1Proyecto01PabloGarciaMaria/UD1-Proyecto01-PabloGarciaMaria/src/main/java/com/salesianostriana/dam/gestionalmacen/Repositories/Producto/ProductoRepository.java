package com.salesianostriana.dam.gestionalmacen.Repositories.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
