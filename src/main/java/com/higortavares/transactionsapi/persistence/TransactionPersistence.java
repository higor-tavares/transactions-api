package com.higortavares.transactionsapi.persistence;

import com.higortavares.transactionsapi.domain.model.Transaction;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionPersistence {
  private final TransactionRepository repository;
  public Transaction save(Transaction transaction) {
    this.repository.save(transaction);
    return Transaction.builder().id(UUID.randomUUID().toString()).build();
  }

  public List<Transaction> findAll() {
    return this.repository.findAll();
  }
}
