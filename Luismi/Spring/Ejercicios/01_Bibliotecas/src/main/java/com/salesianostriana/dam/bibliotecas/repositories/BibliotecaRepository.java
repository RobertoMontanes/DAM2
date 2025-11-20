package com.salesianostriana.dam.bibliotecas.repositories;

import com.salesianostriana.dam.bibliotecas.models.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {
}
