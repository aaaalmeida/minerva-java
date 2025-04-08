package com.aaalmeida.minerva.infrastructure.repositoryImplementation;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import com.aaalmeida.minerva.infrastructure.factory.AuthorFactory;
import com.aaalmeida.minerva.infrastructure.repository.AuthorNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
@AllArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {
    private AuthorNodeRepository authorNodeRepository;

    @Override
    public Author save(Author author) {
        authorNodeRepository.save(AuthorFactory.toEntity(author));
        return author;
    }

    @Override
    public Optional<Author> findById(UUID id) {
        return authorNodeRepository.findById(id).map(AuthorFactory::fromEntity);
    }

    @Override
    public Stream<Author> findByFirstName(String name) {
        return authorNodeRepository
                .findAuthorEntitiesByNameContainingIgnoreCase(name)
                .map(AuthorFactory::fromEntity);
    }

    @Override
    public Stream<Author> findByLastName(String lastName) {
        return authorNodeRepository
                .findAuthorEntitiesByLastNameContainingIgnoreCase(lastName)
                .map(AuthorFactory::fromEntity);
    }

    @Override
    public Stream<Author> findAll() {
        return authorNodeRepository
                .findAll()
                .stream().map(AuthorFactory::fromEntity);
    }

    @Override
    public void deleteById(UUID id) {
        authorNodeRepository.deleteById(id);
    }
}
