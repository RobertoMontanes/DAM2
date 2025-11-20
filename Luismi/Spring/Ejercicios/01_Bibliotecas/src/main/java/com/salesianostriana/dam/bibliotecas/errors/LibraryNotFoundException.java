package com.salesianostriana.dam.bibliotecas.errors;

import lombok.Getter;

@Getter
public class LibraryNotFoundException extends RuntimeException {

    private Long idBiblioteca;

  public LibraryNotFoundException(String message) {
    super(message);
  }

  public LibraryNotFoundException(Long idBiblioteca) {
    super();
    this.idBiblioteca = idBiblioteca;
  }

}
