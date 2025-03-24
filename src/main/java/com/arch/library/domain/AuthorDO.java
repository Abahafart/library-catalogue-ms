package com.arch.library.domain;

import java.time.Instant;

public record AuthorDO(Long authorId, String name, String description, Instant createdAt, Instant updatedAt, int version) {

  public AuthorDO(String name, String description) {
    this(null, name, description, null, null, 0);
  }
  public AuthorDO(long authorId) {
    this(authorId, null, null, null, null, 0);
  }

}
