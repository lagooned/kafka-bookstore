package com.example.book.registry;

public class AddBookRequest {

  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Book toBook() {
    return new Book(this.title);
  }

}
