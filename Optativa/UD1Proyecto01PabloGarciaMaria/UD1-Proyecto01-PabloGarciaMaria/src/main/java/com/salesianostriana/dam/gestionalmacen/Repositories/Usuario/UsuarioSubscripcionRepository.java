package com.salesianostriana.dam.gestionalmacen.Repositories.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.UsuarioSubscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSubscripcionRepository extends JpaRepository<UsuarioSubscripcion,Long> {
}
