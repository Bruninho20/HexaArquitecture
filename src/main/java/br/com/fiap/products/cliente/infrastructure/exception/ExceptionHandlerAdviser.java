package br.com.fiap.products.cliente.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class ExceptionHandlerAdviser {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationErrors>> handle400(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(
                exception
                        .getFieldErrors()
                        .stream()
                        .map(ValidationErrors::new)
                        .toList());
    }
}
