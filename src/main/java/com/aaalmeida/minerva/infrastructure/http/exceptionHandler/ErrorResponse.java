package com.aaalmeida.minerva.infrastructure.http.exceptionHandler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

// RFC 7807 FORMAT
public record ErrorResponse(
//        TODO: fazer um log de possiveis erros cm swagger
        String type,
        String title,
        HttpStatus status,
        String detail,
        String instance,
        LocalDateTime timestamp
) {
}
