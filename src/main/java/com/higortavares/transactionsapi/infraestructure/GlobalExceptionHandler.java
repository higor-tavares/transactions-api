package com.higortavares.transactionsapi.infraestructure;

import com.higortavares.transactionsapi.domain.exception.InvalidAmountException;
import com.higortavares.transactionsapi.domain.exception.InvalidUserException;
import com.higortavares.transactionsapi.web.TransactionResponse;
import com.higortavares.transactionsapi.web.TransactionStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({ InvalidUserException.class, InvalidAmountException.class })
  public ResponseEntity<TransactionResponse> handleValidationException(IllegalArgumentException e) {
    return ResponseEntity.badRequest().body(TransactionResponse.builder()
        .status(TransactionStatus.ERROR)
        .errorMessage(e.getMessage())
        .build());
  }

}
