package com.arch.library.application.ports.output;

import java.util.List;

import com.arch.library.domain.AuthorDO;

public interface AuthorPersistenceManagement {

  AuthorDO save(AuthorDO author);
  AuthorDO getAuthorById(long authorId);
  void deleteAuthorById(long authorId);
  List<AuthorDO> findAuthorsByName(String name);

}
