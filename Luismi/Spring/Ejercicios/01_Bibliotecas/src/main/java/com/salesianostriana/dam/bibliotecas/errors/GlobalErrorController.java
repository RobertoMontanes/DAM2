package com.salesianostriana.dam.bibliotecas.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalErrorController {

    @ExceptionHandler(NotEnoughElementsException.class)
    public ProblemDetail notEnoughElements(NotEnoughElementsException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage()
        );
        problemDetail.setTitle(ex.getObjectType() + " no encontrado/s");
        problemDetail.setType(
                URI.create("http://dam.salesianos-triana.com/biblioteca-not-found"));
        return problemDetail;
    }

    @ExceptionHandler(LibraryNotFoundException.class)
    public ProblemDetail libraryNotFound(LibraryNotFoundException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND, ex.getMessage()
        );
        problemDetail.setTitle("Libreria con ID: "+ex.getIdBiblioteca()+" no encontrada.");
        problemDetail.setType(
          URI.create("http://dam.salesianos-triana.com/biblioteca-not-found"));

        return problemDetail;
    }

    @ExceptionHandler(InvalidLibraryDataException.class)
    public ProblemDetail invalidLibraryData(InvalidLibraryDataException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, ex.getMessage()
        );
        problemDetail.setTitle("El dato introducido en: " + ex.getMessage() + " es erroneo.");
        problemDetail.setType(
                URI.create("http://dam.salesianos-triana.com/biblioteca-invalid-fields"));
        return problemDetail;
    }

}
