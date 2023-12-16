package com.higortavares.transactionsapi.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Transaction {
  private String id;
  private String payer;
  private String payee;
  private LocalDateTime createdAt;
  private BigDecimal amount;
}
