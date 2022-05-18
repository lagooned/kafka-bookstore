package com.example.book.registry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

  BooksConsumerService booksConsumerService;
  BooksProducerService booksProducerService;

  @Autowired
  public BooksService(BooksConsumerService booksConsumerService,
                      BooksProducerService booksProducerService)
  {
    this.booksConsumerService = booksConsumerService;
    this.booksProducerService = booksProducerService;
  }

  public void createBook(Book book) {
    booksProducerService.send(book.getTitle());
  }

}
