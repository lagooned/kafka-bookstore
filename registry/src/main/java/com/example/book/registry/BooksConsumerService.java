package com.example.book.registry;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksConsumerService {

  public static final Logger logger = LoggerFactory.getLogger(BooksConsumerService.class);

  @Autowired
  void buildBooksPipeline(StreamsBuilder streamsBuilder) {
    KStream<String, Book> messageStream = streamsBuilder
      .stream("books", Consumed.with(Serdes.String(), BookSerdes.JSON));

    KTable<String, Book> messageTable = messageStream
      .peek((k, v) -> System.out.println(k + ": " + v))
      .toTable(Materialized.as("booksKeyValueStore"));
  }

}
