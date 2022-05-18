package com.example.book.registry;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetBooks {

  BooksService booksService;

  @Autowired
  GetBooks(BooksService booksService) {
    this.booksService = booksService;
  }

  @GetMapping(value = "/books/", produces = APPLICATION_JSON_VALUE)
  public List<Book> getBooks() {
    return List.of(new Book("tale of two cities"));
  }

  @PostMapping(value = "/book/new", consumes = APPLICATION_JSON_VALUE)
  public Book addBook(@RequestBody AddBookRequest request) {
    Book newBook = request.toBook();
    booksService.createBook(newBook);
    return newBook;
  }

}
