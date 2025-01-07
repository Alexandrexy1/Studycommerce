package com.example.studycommerce.controllers.handlers;

import com.example.studycommerce.DTO.CustomError;
import com.example.studycommerce.DTO.FieldMessage;
import com.example.studycommerce.DTO.ValidationError;
import com.example.studycommerce.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> EntityNotFound(EntityNotFoundException e, HttpServletRequest servletRequest) {
        CustomError error = new CustomError(404, e.getMessage(), servletRequest.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> DataIntegrityViolation(DatabaseException e, HttpServletRequest servletRequest) {
        CustomError error = new CustomError(409, e.getMessage(), servletRequest.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> MethodArgumentNotValid(MethodArgumentNotValidException e, HttpServletRequest servletRequest) {
        ValidationError error = new ValidationError(422, "Dados inválidos", servletRequest.getRequestURI());

        for (FieldError field: e.getBindingResult().getFieldErrors()) {
            error.addError(field.getField(), field.getDefaultMessage());
        }

        return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
