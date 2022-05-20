package com.example.book.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.KeyValueIterator;
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
    ReadOnlyKeyValueStore<String, String> books = kafkaStreams.store(
        StoreQueryParameters.fromNameAndType("booksKeyValueStore", QueryableStoreTypes.keyValueStore()));
    List<Book> bl = new ArrayList<>();
    books.all().forEachRemaining(
        (var kv) -> bl.add(new Book().setId(kv.key).setTitle(kv.value)));
    return bl;
  }

}
