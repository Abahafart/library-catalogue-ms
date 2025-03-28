package com.arch.library.framework.output.file;

import java.util.List;

import org.springframework.stereotype.Component;

import com.arch.library.application.ports.output.BookFile;
import com.arch.library.framework.output.persistence.data.AuthorData;
import com.arch.library.framework.output.persistence.data.BookData;
import com.arch.library.framework.output.persistence.repository.AuthorRepository;
import com.arch.library.framework.output.persistence.repository.BookRepository;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BookFileAdapter implements BookFile {

  private final BookRepository bookRepository;
  private final Faker faker;
  private final AuthorRepository authorRepository;

  @Override
  public void generateBooks() {
    List<AuthorData> authors = authorRepository.findAll();
    int totalAuthors = authors.size();
    int count = 0;
    for (int i = 0; i < 20000; i++) {
      if (count == totalAuthors) {
        count = 0;
      }
      BookData bookData = new BookData();
      bookData.setTitle(faker.book().title());
      bookData.setIsbn(faker.code().isbn13(true));
      bookData.setLanguage("English");
      bookData.setSubject(faker.book().title());
      bookData.setNumberOfPages(faker.number().numberBetween(1, 1000));
      bookData.setPublisher(faker.book().publisher());
      bookData.setAuthor(authors.get(count));
      bookRepository.save(bookData);
      count++;
    }
  }
}
