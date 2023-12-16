package com.higortavares.transactionsapi.web;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import com.higortavares.transactionsapi.usecase.TransactionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionUseCase transactionUseCase;

  @PostMapping
  public ResponseEntity<TransactionResponse> transfer(@RequestBody TransactionRequest request) {
    var response = TransactionResponse.fromModel(transactionUseCase.execute(request.toModel()));
    response.add(linkTo(TransactionController.class).withSelfRel());
    return ResponseEntity.ok(response);
  }
}
