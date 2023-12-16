package com.higortavares.transactionsapi.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.higortavares.transactionsapi.domain.exception.InvalidAmountException;
import com.higortavares.transactionsapi.domain.model.Transaction;
import com.higortavares.transactionsapi.usecase.TransactionUseCase;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {
  @Autowired
  private MockMvc mvc;
  @MockBean
  private TransactionUseCase useCase;
  @Autowired
  private ObjectMapper mapper;

  @Value("${error.invalid-amount}")
  private String invalidAmountError;

  @Test
  void postTransactionSuccess() throws Exception {

    var request = TransactionRequest.builder()
        .payer("first")
        .payee("second")
        .amount(BigDecimal.valueOf(100))
        .build();

    var response = Transaction.builder()
        .id(UUID.randomUUID().toString())
        .payer("first")
        .payee("second")
        .createdAt(LocalDateTime.now())
        .amount(BigDecimal.valueOf(100))
        .build();

    when(useCase.execute(any())).thenReturn(response);
    mvc.perform(
        post("/transactions")
            .contentType(MediaType.APPLICATION_JSON)
            .content(mapper.writeValueAsString(request)))
        .andExpect(jsonPath("_links.self.href").exists())
        .andExpect(jsonPath("errorMessage").isEmpty())
        .andExpect(status().isOk());
  }

  @Test
  void postTransactionWithAmountError() throws Exception {

    var request = TransactionRequest.builder()
        .payer("first")
        .payee("second")
        .build();

    when(useCase.execute(any())).thenThrow(new InvalidAmountException(invalidAmountError));
    mvc.perform(
            post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
        .andExpect(jsonPath("errorMessage").value(invalidAmountError))
        .andExpect(status().isBadRequest());
  }
}
