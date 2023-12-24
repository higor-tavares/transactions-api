package com.higortavares.transactionsapi.persistence;

import com.higortavares.transactionsapi.domain.model.Transaction;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TransactionRepository {
  void save(Transaction transaction) {}

  List<Transaction> findAll() {
    return Collections.emptyList();
  }
}
