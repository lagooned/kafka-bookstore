package com.example.book.registry;

import org.apache.kafka.clients.KafkaClient;
import org.apache.kafka.streams.KafkaStreams;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;

@SpringBootTest
class RegistryApplicationTests {

  @MockBean
  KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

	@Test
	void contextLoads() {}

}
