package com.salesianostriana.dam.gestionsuscripciones.Repositories.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
