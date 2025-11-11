package com.salesianostriana.dam.gestionalmacen.Repositories.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
