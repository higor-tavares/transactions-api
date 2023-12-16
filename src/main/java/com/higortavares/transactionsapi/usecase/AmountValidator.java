package com.higortavares.transactionsapi.usecase;

import com.higortavares.transactionsapi.domain.exception.InvalidAmountException;
import com.higortavares.transactionsapi.domain.model.Transaction;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AmountValidator implements TransactionValidator {
  @Value("${error.invalid-amount}")
  private String message;

  @Override
  public void validate(Transaction transaction) {
    if (transaction.getAmount() == null || transaction.getAmount().compareTo(BigDecimal.ZERO) < 1) {
      throw new InvalidAmountException(message);
    }
  }
}
