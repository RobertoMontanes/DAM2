package com.salesianostriana.dam.gestionalmacen.Repositories;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long> {
}
