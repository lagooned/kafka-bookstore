package com.example.book.registry;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutBooks {

  BooksService booksService;

  @Autowired
  PutBooks(BooksService booksService) {
    this.booksService = booksService;
  }

  @PostMapping(value = "/book/new", consumes = APPLICATION_JSON_VALUE)
  public Book addBook(@RequestBody AddBookRequest request) {
    return booksService.createBook(request.toBook());
  }

}
