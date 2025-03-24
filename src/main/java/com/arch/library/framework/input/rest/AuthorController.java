package com.arch.library.framework.input.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arch.library.application.usecases.AuthorManagement;
import com.arch.library.domain.AuthorDO;
import com.arch.library.domain.rest.request.AuthorRequest;
import com.arch.library.domain.rest.response.AuthorResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorManagement authorManagement;

  @PostMapping
  public AuthorResponse save(@RequestBody AuthorRequest request) {
    AuthorDO authorDO = new AuthorDO(request.getName(), request.getDescription());
    AuthorDO created = authorManagement.createAuthor(authorDO);
    return new AuthorResponse(created.authorId(), created.name(), created.description(), created.createdAt(), created.updatedAt(), created.version());
  }

}
