package com.higortavares.transactionsapi.domain.exception;

public class InvalidUserException extends IllegalArgumentException {
  public InvalidUserException(String message) {
    super(message);
  }
}
