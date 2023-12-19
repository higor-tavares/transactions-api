package com.higortavares.transactionsapi.infraestructure;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class Log4jTest {

  @Test
  void shouldLogHello() {
    log.info("Hello world!");
  }

  @Test
  void shouldLogError(){
    log.error("FAILED SUCCESSFULLY");
  }

  @Test
  void shouldLogFormatted() {
    String name = "Paulo";
    int coins = 10;
    log.info("Welcome {} do you have {} coins!", name, coins);
  }
}
