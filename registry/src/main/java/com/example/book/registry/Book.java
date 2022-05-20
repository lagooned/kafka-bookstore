package com.example.book.registry;

public class Book {

  private String id;
  private String title;

  public String getId() {
    return id;
  }

  public Book setId(String id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Book setTitle(String title) {
    this.title = title;
    return this;
  }

}
