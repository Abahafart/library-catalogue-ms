package com.arch.library.framework.output.persistence;

import static com.arch.library.domain.constant.Information.AUTHOR_NOT_FOUND_BY_ID;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.arch.library.application.ports.output.AuthorPersistenceManagement;
import com.arch.library.domain.AuthorDO;
import com.arch.library.domain.exception.InformationNotFoundException;
import com.arch.library.framework.output.persistence.data.AuthorData;
import com.arch.library.framework.output.persistence.repository.AuthorRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AuthorPostgreSQLAdapter implements AuthorPersistenceManagement {

  private final AuthorRepository authorRepository;

  @Override
  public AuthorDO save(AuthorDO author) {
    AuthorData data = new AuthorData();
    data.setName(author.name());
    data.setDescription(author.description());
    data = authorRepository.save(data);
    return convertToAuthorDO(data);
  }

  @Override
  public AuthorDO getAuthorById(long authorId) {
    AuthorData data = authorRepository.findById(authorId).orElseThrow(() -> new InformationNotFoundException(String.format(AUTHOR_NOT_FOUND_BY_ID, authorId)));
    return convertToAuthorDO(data);
  }

  @Override
  public void deleteAuthorById(long authorId) {
    AuthorData data = authorRepository.findById(authorId).orElseThrow(() -> new InformationNotFoundException(String.format(AUTHOR_NOT_FOUND_BY_ID, authorId)));
    authorRepository.delete(data);
  }

  @Override
  public List<AuthorDO> findAuthorsByName(String name) {
    return authorRepository.findByNameContainingIgnoreCase(name).stream().map(this::convertToAuthorDO).toList();
  }

  protected AuthorDO convertToAuthorDO(AuthorData data) {
    return new AuthorDO(data.getAuthorId(), data.getName(), data.getDescription(), data.getCreatedAt(), data.getUpdatedAt(), data.getVersion());
  }
}
