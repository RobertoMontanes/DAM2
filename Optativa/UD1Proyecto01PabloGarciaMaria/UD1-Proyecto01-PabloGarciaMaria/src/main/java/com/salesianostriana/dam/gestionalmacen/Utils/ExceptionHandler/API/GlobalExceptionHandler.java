package com.salesianostriana.dam.gestionalmacen.Utils.ExceptionHandler.API;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

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
        } else if (e.getMessage().toLowerCase().contains("uk_nombre")) {
            errorGenerator = "El nombre";
        } else {
            errorGenerator = "Dato desconocido";
        }

        return ResponseEntity
                .badRequest()
                .body("Error: "+errorGenerator+" ya existe o es nulo");
    }

    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(jakarta.validation.ConstraintViolationException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getConstraintViolations().forEach(violation -> {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(field, message);
        });

        log.error("Errores de validación: {}", errors);

        return ResponseEntity.badRequest().body(errors);
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
                .body("Error: El recurso solicitado no existe");
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
