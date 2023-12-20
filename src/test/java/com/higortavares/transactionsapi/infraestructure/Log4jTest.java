package com.higortavares.transactionsapi.infraestructure;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Test;

class Log4jTest {
  private static final Logger log = LogManager.getLogger("HelloWorld");
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
