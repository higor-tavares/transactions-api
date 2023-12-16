package com.higortavares.transactionsapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private String id;
  private String fullName;
  private String document;
  private String email;
  private String password;
  private Wallet wallet;
}
