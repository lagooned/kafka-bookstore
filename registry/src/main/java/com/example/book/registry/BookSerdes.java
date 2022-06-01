package com.example.book.registry;

import java.util.Map;

import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class BookSerdes {

  public static Map<String, String> CONFIG_MAP = Map.of(
    JsonDeserializer.TRUSTED_PACKAGES, "com.example.book.registry",
    JsonDeserializer.VALUE_DEFAULT_TYPE, new Book().getClass().getName());

  public static BookJsonDeserializer BOOK_JSON_DESERIALIZER = new BookJsonDeserializer();
  public static BookJsonSerializer BOOK_JSON_SERIALIZER = new BookJsonSerializer();
  public static JsonSerde<Book> JSON = new BookSerde();

  public static class BookJsonDeserializer extends JsonDeserializer<Book> {
    public BookJsonDeserializer() {
      super(); this.configure(CONFIG_MAP, false);
    }
  }

  public static class BookJsonSerializer extends JsonSerializer<Book> {
    public BookJsonSerializer() {
      super(); this.configure(CONFIG_MAP, false);
    }
  }

  public static class BookSerde extends JsonSerde<Book> {
    public BookSerde() {
      super(BOOK_JSON_SERIALIZER, BOOK_JSON_DESERIALIZER);
    }
  }

}
