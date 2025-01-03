package com.example.studycommerce.controllers.handlers;

import com.example.studycommerce.DTO.CustomError;
import com.example.studycommerce.services.exceptions.DatabaseException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
