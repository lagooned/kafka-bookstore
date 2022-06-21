package com.example.book.registry;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBooks {

  BooksService booksService;

  @Autowired
  GetBooks(BooksService booksService) {
    this.booksService = booksService;
  }

  @CrossOrigin
  @GetMapping(value = "/books", produces = APPLICATION_JSON_VALUE)
  public List<Book> getBooks() {
    return booksService.getAllBooks();
  }

}
