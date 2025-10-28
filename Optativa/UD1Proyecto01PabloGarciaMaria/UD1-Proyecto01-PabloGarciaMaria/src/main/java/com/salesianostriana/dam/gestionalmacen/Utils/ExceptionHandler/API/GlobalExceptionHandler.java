package com.salesianostriana.dam.gestionalmacen.Utils.ExceptionHandler.API;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolation(DataIntegrityViolationException e) {
        String errorGenerator = "";

        log.error("Error: " + e.getMessage().toLowerCase());

        if (e.getMessage().toLowerCase().contains("uk_email")) {
            errorGenerator = "El email";
        } else if (e.getMessage().toLowerCase().contains("uk_username")) {
            errorGenerator = "El username";
        } else {
            errorGenerator = "Dato desconocido";
        }

        return ResponseEntity
                .badRequest()
                .body("Error: "+errorGenerator+" ya existe o es nulo");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolation(ConstraintViolationException e) {
        log.error(e.getMessage());
        return ResponseEntity
                .badRequest()
                .body("Error: los datos proporcionados no cumplen las validaciones");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<String> handleNoResourceFound(NoResourceFoundException e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("El recurso solicitado no existe");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        log.error("Error capturado: ", e);
        log.error(e.getMessage());
        return ResponseEntity
                .internalServerError()
                .body("Error interno del servidor");
    }

}
