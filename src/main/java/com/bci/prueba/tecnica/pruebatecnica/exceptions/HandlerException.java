package com.bci.prueba.tecnica.pruebatecnica.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import com.bci.prueba.tecnica.pruebatecnica.entities.Error;

import jakarta.validation.ConstraintViolationException;
@ControllerAdvice
public class HandlerException {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException e) {
        Error error = new Error();
        error.setMensaje(e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Error> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        Error error = new Error();
        error.setMensaje("El parametro " + e.getParameterName() + " es requerido");
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        Error error = new Error();
        error.setMensaje("El email ya se encuentra registrado");
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Error> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String,String> errorMap = new HashMap<>();
        e.getConstraintViolations().forEach(error -> {
            errorMap.put(error.getPropertyPath().toString(), error.getMessage());
        });
        Error error = new Error();
        error.setMensaje(errorMap.toString());
        return ResponseEntity.badRequest().body(error);
    }

}
