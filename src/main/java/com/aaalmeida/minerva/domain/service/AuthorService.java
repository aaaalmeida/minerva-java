package com.aaalmeida.minerva.domain.service;

import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface AuthorService {
    AuthorEntity save(AuthorEntity author);

    AuthorEntity followAuthor(UUID baseId, UUID targetId);

    Boolean unfollowAuthor(UUID baseId, UUID targetId);

    Optional<AuthorEntity> findById(UUID id);

    Stream<AuthorEntity> findByFirstName(String name);

    Stream<AuthorEntity> findByLastName(String lastName);

    Stream<AuthorEntity> findAll();

    void deleteById(UUID id);
}