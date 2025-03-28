package com.arch.library.domain.rest.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest implements Serializable {

  private String title;
  private String isbn;
  private String subject;
  private String publisher;
  private String language;
  private int numberOfPages;
  private long authorId;
  private int items;

  @Override
  public String toString() {
    return "BookRequest{" +
        "title='" + title + '\'' +
        ", isbn='" + isbn + '\'' +
        ", subject='" + subject + '\'' +
        ", publisher='" + publisher + '\'' +
        ", language='" + language + '\'' +
        ", numberOfPages=" + numberOfPages +
        ", authorId=" + authorId +
        ", items=" + items +
        '}';
  }
}
