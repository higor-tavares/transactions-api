package com.higortavares.transactionsapi.usecase;

import com.higortavares.transactionsapi.domain.exception.InvalidUserException;
import com.higortavares.transactionsapi.domain.model.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FraudValidator implements  TransactionValidator {

  @Value("${error.payer-payee-required}")
  private String required;
  @Value("${error.payer-payee-fraud}")
  private String fraud;

  @Override
  public void validate(Transaction transaction) {
    if (transaction.getPayer() == null || transaction.getPayee() == null) {
      throw new InvalidUserException(required);
    }
    if (transaction.getPayer().equals(transaction.getPayee())) {
      throw new InvalidUserException(fraud);
    }
  }
}
