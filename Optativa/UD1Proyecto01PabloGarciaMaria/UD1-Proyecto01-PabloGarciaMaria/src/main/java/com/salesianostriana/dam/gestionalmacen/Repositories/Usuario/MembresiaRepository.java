package com.salesianostriana.dam.gestionalmacen.Repositories.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia,Long> {

    @Query(
            "SELECT m FROM Membresia m WHERE m.usuario = :usuario"
    )
    List<Membresia> findAllByUsuario(Usuario usuario);

    @Query(
            "SELECT m FROM Membresia m WHERE m.usuario = :usuario AND m.activa = true"
    )
    Optional<Membresia> findActiveByUsuario(Usuario usuario);
}
