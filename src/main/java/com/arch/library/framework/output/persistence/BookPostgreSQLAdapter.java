package com.arch.library.framework.output.persistence;

import static com.arch.library.domain.constant.Information.BOOK_NOT_FOUND_BY_ID;
import static com.arch.library.domain.constant.Information.BOOK_NOT_FOUND_BY_ISBN;
import static com.arch.library.domain.constant.Information.BOOK_NOT_FOUND_BY_TITLE;

import org.springframework.stereotype.Repository;

import com.arch.library.application.ports.output.BookPersistenceManagement;
import com.arch.library.domain.BookDO;
import com.arch.library.domain.exception.InformationNotFoundException;
import com.arch.library.framework.mapper.BookMapper;
import com.arch.library.framework.output.persistence.data.BookData;
import com.arch.library.framework.output.persistence.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookPostgreSQLAdapter implements BookPersistenceManagement {

  private final BookRepository bookRepository;
  private final BookMapper bookMapper;

  @Override
  public BookDO save(BookDO book) {
    BookData data = bookMapper.fromModel(book);
    data = bookRepository.save(data);
    return bookMapper.toModel(data);
  }

  @Override
  public BookDO update(BookDO book) {
    BookData data = bookMapper.fromModel(book);
    data = bookRepository.save(data);
    return bookMapper.toModel(data);
  }

  @Override
  public void delete(long bookId) {
    BookData found = bookRepository.findById(bookId).orElseThrow(() -> new InformationNotFoundException(String.format(BOOK_NOT_FOUND_BY_ID, bookId)));
    bookRepository.delete(found);
  }

  @Override
  public int countBooks() {
    return (int)bookRepository.count();
  }

  @Override
  public BookDO getBookByISBN(String isbn) {
    BookData data = bookRepository.findByIsbn(isbn).orElseThrow(() -> new InformationNotFoundException(String.format(BOOK_NOT_FOUND_BY_ISBN, isbn)));
    return bookMapper.toModel(data);
  }

  @Override
  public BookDO getBookByTitle(String title) {
    BookData data = bookRepository.findByTitle(title).orElseThrow(() -> new InformationNotFoundException(String.format(BOOK_NOT_FOUND_BY_TITLE, title)));
    return bookMapper.toModel(data);
  }

  @Override
  public BookDO getBookById(Long id) {
    BookData data = bookRepository.findWithAuthorByBookId(id).orElseThrow(() -> new InformationNotFoundException(String.format(BOOK_NOT_FOUND_BY_ID, id)));
    return bookMapper.toModel(data);
  }
}
