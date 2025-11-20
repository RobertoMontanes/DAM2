package com.salesianostriana.dam.monumentos.repositorios;

import com.salesianostriana.dam.monumentos.modelos.Monumento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonumentoRepository extends JpaRepository<Monumento, Long> {
}
