package br.com.fiap.products.cliente.infrastructure.exception;

import org.springframework.validation.FieldError;

public class ValidationErrors {

    private String field;

    public ValidationErrors(FieldError fieldError) {
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

}
