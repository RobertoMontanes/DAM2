package com.salesianostriana.dam.gestionalmacen.Repositories.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @Query(
            "SELECT m FROM Membresia m WHERE m.usuario.nombre = :username AND m.activa = true"
    )
    Optional<Membresia> findMembresiaByUsuarioNombreAndActivaIsTrue(@NotBlank(message = "El username no puede estar vacío") @Size(min = 3, max = 30, message = "El username debe tener entre 3 y 30 caracteres") String username);

    List<Membresia> findByUsuario(Usuario u);
}
