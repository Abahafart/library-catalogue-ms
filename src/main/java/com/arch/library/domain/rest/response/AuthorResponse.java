package com.arch.library.domain.rest.response;

import java.time.Instant;

public record AuthorResponse(long authorId, String name, String description, Instant createdAt, Instant updatedAt, int version) {

}
