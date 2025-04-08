package com.aaalmeida.minerva.infrastructure.http.exceptionHandler;

import com.aaalmeida.minerva.domain.exception.EntityNotFoundException;
import com.aaalmeida.minerva.domain.exception.InvalidUuidException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

//  TODO: adicionar referencia ao log de cada error depois que forem criados
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidUuidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidUuid(InvalidUuidException e, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                "",
                "Invalid UUID",
                HttpStatus.BAD_REQUEST,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                "",
                "Entity not found",
                HttpStatus.NOT_FOUND,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception e, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(
                "",
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR,
                e.getMessage(),
                request.getRequestURI(),
                LocalDateTime.now()
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(response);
    }
}
