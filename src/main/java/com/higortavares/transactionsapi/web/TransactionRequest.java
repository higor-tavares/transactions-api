package com.higortavares.transactionsapi.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.higortavares.transactionsapi.domain.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Builder
public class TransactionRequest {
  private BigDecimal amount;
  String payer;
  private String payee;

  public Transaction toModel() {
    return Transaction.builder()
        .id(UUID.randomUUID().toString())
        .amount(this.amount)
        .payee(this.payee)
        .payer(this.payer)
        .createdAt(LocalDateTime.now())
        .build();
  }
}
