package com.arch.library.application.usecases;

import java.util.Map;

import com.arch.library.domain.BookDO;

public interface BookManagement {

  BookDO createBook(BookDO book);
  int countBooks();
  BookDO getBookByISBN(String ISBN);
  BookDO getBookByTitle(String title);
  BookDO updateBook(BookDO book);
  void deleteBook(long bookId);
  BookDO getBookByParams(Map<String, String> params);

}
