package com.example.book.registry;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(
  properties = "spring.kafka.bootstrap-servers=localhost:9092")
@EmbeddedKafka(
  partitions = 1,
  brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" },
  topics = { "books" })
@DirtiesContext
class RegistryApplicationTests {

  @Test
  void contextLoads() {}

}
