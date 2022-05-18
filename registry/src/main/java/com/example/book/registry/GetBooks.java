package com.example.book.registry;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBooks {

  @GetMapping(value = "/books/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Book> getBooks() {
    return List.of(new Book("tale of two cities"));
  }

}
