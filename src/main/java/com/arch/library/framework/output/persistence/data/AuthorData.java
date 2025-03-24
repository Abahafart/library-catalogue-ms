package com.arch.library.framework.output.persistence.data;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "authors")
@EntityListeners(AuditingEntityListener.class)
public class AuthorData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long authorId;
  private String name;
  private String description;
  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<BookData> books;
  @CreatedDate
  private Instant createdAt;
  @LastModifiedDate
  private Instant updatedAt;
  @Version
  private int version;

}
