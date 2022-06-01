package com.example.book.registry;

import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

  BooksConsumerService booksConsumerService;
  BooksProducerService booksProducerService;
  StreamsBuilderFactoryBean streamsBuilderFactoryBean;

  @Autowired
  public BooksService(BooksConsumerService booksConsumerService,
                      BooksProducerService booksProducerService,
                      StreamsBuilderFactoryBean streamsBuilderFactoryBean)
  {
    this.booksConsumerService = booksConsumerService;
    this.booksProducerService = booksProducerService;
    this.streamsBuilderFactoryBean = streamsBuilderFactoryBean;
  }

  public Book createBook(Book book) {
    return booksProducerService.send(book);
  }

  public List<Book> getAllBooks() {
    KafkaStreams kafkaStreams = streamsBuilderFactoryBean.getKafkaStreams();
    ReadOnlyKeyValueStore<String, Book> books
      = kafkaStreams.store(
        StoreQueryParameters.fromNameAndType(
          "booksKeyValueStore", QueryableStoreTypes.keyValueStore()));
    return stream(spliteratorUnknownSize(books.all(), 0), false)
      .map(kv -> kv.value)
      .collect(Collectors.toList());
  }

}
