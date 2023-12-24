package com.higortavares.transactionsapi.persistence;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.higortavares.transactionsapi.domain.model.Transaction;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class TransactionPersistenceTest {

  @Autowired
  private TransactionPersistence persistence;
  @MockBean
  private TransactionRepository repository;

  @Test
  void shouldSaveWithSuccess() {
    var transaction = mock(Transaction.class);
    var transactionSaved = persistence.save(transaction);
    assertNotNull(transactionSaved.getId());
  }

  @Test
  void throwErrorWhileSavingTransaction() {
    var transaction = mock(Transaction.class);
    doThrow(RuntimeException.class).when(repository).save(any(Transaction.class));
    assertThrows(RuntimeException.class, () -> {
      persistence.save(transaction);
    });
  }

  @Test
  void shouldListTransactions() {
    when(repository.findAll()).thenReturn(getTransactions());
    List<Transaction> transactions = persistence.findAll();
    assertNotNull(transactions);
    assertNotEquals(0, transactions.size());
  }

  private List<Transaction> getTransactions() {
    var t1 = Transaction.builder().id("1").build();
    var t2 = Transaction.builder().id("2").build();
    return Arrays.asList(t1, t2);
  }

}
