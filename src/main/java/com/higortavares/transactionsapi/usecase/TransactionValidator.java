package com.higortavares.transactionsapi.usecase;

import com.higortavares.transactionsapi.domain.model.Transaction;

public interface TransactionValidator {
  void validate(Transaction transaction);
}
