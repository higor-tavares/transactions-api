package com.higortavares.transactionsapi.usecase;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ConfigValidator {
  private final AmountValidator amountValidator;
  private final FraudValidator fraudValidator;

  @Bean
  public List<TransactionValidator> getValidators() {
    return List.of(amountValidator, fraudValidator);
  }
}
