package com.arch.library.framework.output.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arch.library.framework.output.persistence.data.AuthorData;

public interface AuthorRepository extends JpaRepository<AuthorData, Long> {

  List<AuthorData> findByNameContainingIgnoreCase(String name);
}
