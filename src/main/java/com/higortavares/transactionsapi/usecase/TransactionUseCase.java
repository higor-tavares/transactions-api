package com.higortavares.transactionsapi.usecase;

import com.higortavares.transactionsapi.domain.model.Transaction;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransactionUseCase {
  private final List<TransactionValidator> validators;

  public Transaction execute(Transaction transaction) {
    validators.forEach(validator -> validator.validate(transaction));
    return  transaction;
  }
}
