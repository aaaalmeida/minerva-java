package com.aaalmeida.minerva.infrastructure.repository;

import com.aaalmeida.minerva.infrastructure.persistence.entity.AuthorEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AuthorNodeRepository extends Neo4jRepository<AuthorEntity, UUID> {
    Stream<AuthorEntity> findAuthorEntitiesByNameContainingIgnoreCase(String name);
    Stream<AuthorEntity> findAuthorEntitiesByLastNameContainingIgnoreCase(String lastName);
}
