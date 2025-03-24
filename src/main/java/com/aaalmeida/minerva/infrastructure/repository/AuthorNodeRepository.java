package com.aaalmeida.minerva.infrastructure.repository;

import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AuthorNodeRepository extends Neo4jRepository<AuthorEntity, UUID> {
    Stream<AuthorEntity> findAuthorEntitiesByNameContainingIgnoreCase(@NotEmpty(message = "Name is required") @Pattern(regexp = "([a-zA-Z]|[à-ü]|[À-Ü])+([a-zA-Z]|[à-ü]|[À-Ü]| |')*") String name);
    Stream<AuthorEntity> findAuthorEntitiesByLastNameContainingIgnoreCase(@NotEmpty(message = "Last name is required") @Pattern(regexp = "([a-zA-Z]|[à-ü]|[À-Ü])+([a-zA-Z]|[à-ü]|[À-Ü]| |')*") String lastName);
}
