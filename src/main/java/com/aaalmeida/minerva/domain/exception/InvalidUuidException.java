package com.aaalmeida.minerva.domain.exception;

public class InvalidUuidException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;

    public InvalidUuidException(String message) {
        super(message);
    }
}
