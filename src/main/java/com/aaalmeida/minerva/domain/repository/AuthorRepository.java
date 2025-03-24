package com.aaalmeida.minerva.domain.repository;

import com.aaalmeida.minerva.domain.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(UUID id);
    List<Author> findByFirstName(String name);
    List<Author> findByLastName(String lastName);
    List<Author> findAll();
    void deleteById(UUID id);
}
