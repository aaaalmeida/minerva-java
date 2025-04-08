package com.aaalmeida.minerva.domain.repository;

import com.aaalmeida.minerva.domain.model.Author;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface AuthorRepository {
    Author save(Author author);
    Optional<Author> findById(UUID id);
    Stream<Author> findByFirstName(String name);
    Stream<Author> findByLastName(String lastName);
    Stream<Author> findAll();
    void deleteById(UUID id);
}