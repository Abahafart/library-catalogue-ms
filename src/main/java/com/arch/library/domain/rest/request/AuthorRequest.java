package com.arch.library.domain.rest.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorRequest implements Serializable {

  @Override
  public String toString() {
    return "AuthorRequest {" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        '}';
  }

  private String name;
  private String description;

}
