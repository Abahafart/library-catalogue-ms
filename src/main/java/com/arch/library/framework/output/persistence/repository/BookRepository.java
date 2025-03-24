package com.arch.library.framework.output.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.arch.library.framework.output.persistence.data.BookData;

public interface BookRepository extends JpaRepository<BookData, Long> {

  @EntityGraph(attributePaths = {"author"})
  Optional<BookData> findByIsbn(String isbn);
  @EntityGraph(attributePaths = {"author"})
  Optional<BookData> findByTitle(String title);
  @EntityGraph(attributePaths = {"author"})
  Optional<BookData> findWithAuthorByBookId(long id);

}
