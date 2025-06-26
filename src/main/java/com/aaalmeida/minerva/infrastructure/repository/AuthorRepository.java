package com.aaalmeida.minerva.infrastructure.repository;

import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, UUID> {
    Stream<AuthorEntity> findAuthorEntitiesByNameContainingIgnoreCase(String name);
    Stream<AuthorEntity> findAuthorEntitiesByLastNameContainingIgnoreCase(String lastName);
}
