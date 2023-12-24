package com.higortavares.transactionsapi.persistence;

import com.higortavares.transactionsapi.domain.model.Transaction;
import java.util.List;

public interface TransactionRepository {
  void save(Transaction transaction);

  List<Transaction> findAll();
}
