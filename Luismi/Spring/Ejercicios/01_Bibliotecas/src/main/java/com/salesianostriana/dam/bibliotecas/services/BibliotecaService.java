package com.salesianostriana.dam.bibliotecas.services;

import com.salesianostriana.dam.bibliotecas.errors.InvalidLibraryDataException;
import com.salesianostriana.dam.bibliotecas.errors.LibraryNotFoundException;
import com.salesianostriana.dam.bibliotecas.errors.NotEnoughElementsException;
import com.salesianostriana.dam.bibliotecas.models.Biblioteca;
import com.salesianostriana.dam.bibliotecas.models.dtos.BibliotecaDetailsResponse;
import com.salesianostriana.dam.bibliotecas.models.dtos.CreateBibliotecaRequest;
import com.salesianostriana.dam.bibliotecas.models.dtos.EditBibliotecaRequest;
import com.salesianostriana.dam.bibliotecas.repositories.BibliotecaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BibliotecaService {

    private final BibliotecaRepository repository;

    public List<Biblioteca> findAll() {
        return repository.findAll();
    }

    public Biblioteca findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new LibraryNotFoundException(id));
    }

    public Biblioteca save(Biblioteca biblioteca) {
        return repository.save(biblioteca);
    }

    public List<Biblioteca>  listarBibliotecas() {
        List<Biblioteca> bibliotecas = this.findAll();
        if (bibliotecas.isEmpty()) {
            throw new NotEnoughElementsException("No se han encontrado registros de bibliotecas.", "Listado de bibliotecas");
        }
        return bibliotecas;
    }

    public Biblioteca detallesBiblioteca(Long id) {
        return this.findById(id);
    }

    public Biblioteca crearBiblioteca(CreateBibliotecaRequest bibliotecaDTO) {

        if (bibliotecaDTO.library_name().isEmpty()) {
            throw new InvalidLibraryDataException("library_name");
        }

        return this.save(bibliotecaDTO.to());
    }

    public Biblioteca modificarBiblioteca(Long id, EditBibliotecaRequest bibliotecaDTO) {
        Biblioteca b = this.findById(id);

        if (bibliotecaDTO.library_name().isEmpty()) {
            throw new InvalidLibraryDataException("library_name");
        }

        return this.save(b.modify(bibliotecaDTO.to()));
    }

    public String eliminarBiblioteca(Long id) {
        Biblioteca b = this.findById(id);
        this.repository.delete(b);
        return "Biblioteca eliminada correctamente.";
    }
}
