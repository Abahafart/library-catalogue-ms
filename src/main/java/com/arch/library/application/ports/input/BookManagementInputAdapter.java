package com.arch.library.application.ports.input;

import static com.arch.library.domain.constant.InformationParams.ISBN;
import static com.arch.library.domain.constant.InformationParams.TITLE;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.arch.library.application.ports.output.AuthorPersistenceManagement;
import com.arch.library.application.ports.output.BookPersistenceManagement;
import com.arch.library.application.usecases.BookManagement;
import com.arch.library.domain.AuthorDO;
import com.arch.library.domain.BookDO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookManagementInputAdapter implements BookManagement {

  private final BookPersistenceManagement persistenceManagement;
  private final AuthorPersistenceManagement authorPersistenceManagement;

  @Override
  public BookDO createBook(BookDO book) {
    AuthorDO found = authorPersistenceManagement.getAuthorById(book.getAuthor().authorId());
    book.setAuthor(found);
    BookDO saved = persistenceManagement.save(book);
    saved.setAuthor(found);
    return saved;
  }

  @Override
  public int countBooks() {
    return persistenceManagement.countBooks();
  }

  @Override
  public BookDO getBookByISBN(String ISBN) {
    return persistenceManagement.getBookByISBN(ISBN);
  }

  @Override
  public BookDO getBookByTitle(String title) {
    return persistenceManagement.getBookByTitle(title);
  }

  @Override
  public BookDO updateBook(BookDO book) {
    return persistenceManagement.update(book);
  }

  @Override
  public void deleteBook(long bookId) {
    persistenceManagement.delete(bookId);
  }

  @Override
  public BookDO getBookByParams(Map<String, String> params) {
    BookDO found = new BookDO();
    if (params.get(ISBN) != null) {
      found = getBookByISBN(params.get(ISBN));
    }
    if (params.get(TITLE) != null) {
      found = getBookByTitle(params.get(TITLE));
    }
    return found;
  }
}
