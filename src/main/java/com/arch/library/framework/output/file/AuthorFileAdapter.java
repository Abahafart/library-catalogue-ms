package com.arch.library.framework.output.file;

import org.springframework.stereotype.Component;

import com.arch.library.application.ports.output.AuthorFile;
import com.arch.library.framework.output.persistence.data.AuthorData;
import com.arch.library.framework.output.persistence.repository.AuthorRepository;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthorFileAdapter implements AuthorFile {

  private final Faker faker;
  private final AuthorRepository authorRepository;

  @Override
  public void createRecords() {
    for (int i = 0; i < 10; i++) {
      AuthorData authorData = new AuthorData();
      authorData.setName(faker.name().fullName());
      authorData.setDescription(faker.color().name());
      authorRepository.save(authorData);
    }
  }
}
