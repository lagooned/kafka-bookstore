package com.example.book.registry;

import org.apache.kafka.streams.KafkaStreams;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class RegistryApplicationTests {

  @MockBean
  KafkaStreams mockStream;

	@Test
	void contextLoads() {}

}
