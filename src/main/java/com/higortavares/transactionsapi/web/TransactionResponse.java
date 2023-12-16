package com.higortavares.transactionsapi.web;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.higortavares.transactionsapi.domain.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;

@Builder
@Getter
public class TransactionResponse extends RepresentationModel<TransactionResponse> {
  private String transactionId;
  private BigDecimal amount;
  private String payer;
  private String payee;
  private TransactionStatus status;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;
  private String errorMessage;

  public static TransactionResponse fromModel(Transaction transaction) {
    return TransactionResponse.builder()
        .transactionId(transaction.getId())
        .amount(transaction.getAmount())
        .payer(transaction.getPayer())
        .payee(transaction.getPayee())
        .createdAt(transaction.getCreatedAt())
        .status(TransactionStatus.SUCCESS)
        .build();
  }
}
