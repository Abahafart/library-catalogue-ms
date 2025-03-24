package com.arch.library.domain.exception;

import lombok.Getter;

@Getter
public class InformationNotFoundException extends RuntimeException {

  private String message;
  public InformationNotFoundException(String message) {
    super(message);
    this.message = message;
  }
}
