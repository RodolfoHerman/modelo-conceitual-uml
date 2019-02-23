package br.com.rodolfo.loja.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rodolfo.loja.services.exceptions.ObjectNotFoundException;

/**
 * Manipulador de exceções do recurso
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException o, HttpServletRequest request) {

        StandardError standardError = new StandardError(HttpStatus.NOT_FOUND.value(), o.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standardError);
    }
}