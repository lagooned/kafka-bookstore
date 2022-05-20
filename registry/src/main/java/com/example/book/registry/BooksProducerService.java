package com.example.book.registry;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BooksProducerService {

  public static final Logger logger = LoggerFactory.getLogger(BooksProducerService.class);

  private KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public BooksProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void send(String message) {
    logger.info("sending message -> {}", message);
    this.kafkaTemplate.send("books", UUID.randomUUID().toString(), message);
  }

}
