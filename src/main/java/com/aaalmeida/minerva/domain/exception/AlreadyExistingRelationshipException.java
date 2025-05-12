package com.aaalmeida.minerva.domain.exception;

public class AlreadyExistingRelationshipException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public AlreadyExistingRelationshipException(String message) {
        super(message);
    }
}
