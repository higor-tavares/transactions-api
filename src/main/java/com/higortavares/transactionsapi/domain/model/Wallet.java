package com.higortavares.transactionsapi.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Wallet {
  private Long amount;
}
