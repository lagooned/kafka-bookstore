package com.example.book.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BooksConsumerService {

  public static final Logger logger = LoggerFactory.getLogger(BooksConsumerService.class);

  @KafkaListener(topics = "books", groupId = "ed40a8b55a5ba7df9476fb07ad813528")
  public void consume(String message) {
    logger.info("message received -> {}", message);
  }

}
