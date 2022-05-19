package com.example.book.registry;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksConsumerService {

  private static final Serde<String> STRING_SERDE = Serdes.String();

  public static final Logger logger = LoggerFactory.getLogger(BooksConsumerService.class);

  @Autowired
  void buildBooksPipeline(StreamsBuilder streamsBuilder) {
    KStream<String, String> messageStream = streamsBuilder
      .stream("books", Consumed.with(STRING_SERDE, STRING_SERDE));

    messageStream.foreach((k, v) -> System.out.println(k + ":" + v));
  }

}
