package com.arch.library.application.ports.input;

import org.springframework.stereotype.Service;

import com.arch.library.application.ports.output.AuthorPersistenceManagement;
import com.arch.library.application.usecases.AuthorManagement;
import com.arch.library.domain.AuthorDO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorManagementInputPort implements AuthorManagement {

  private final AuthorPersistenceManagement authorPersistenceManagement;

  @Override
  public AuthorDO createAuthor(AuthorDO author) {
    return authorPersistenceManagement.save(author);
  }

  @Override
  public AuthorDO getAuthorById(long authorId) {
    return authorPersistenceManagement.getAuthorById(authorId);
  }

  @Override
  public void deleteAuthorById(long authorId) {
    authorPersistenceManagement.deleteAuthorById(authorId);
  }
}
