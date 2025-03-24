package com.arch.library.application.usecases;

import com.arch.library.domain.AuthorDO;

public interface AuthorManagement {

  AuthorDO createAuthor(AuthorDO author);
  AuthorDO getAuthorById(long authorId);
  void deleteAuthorById(long authorId);

}
