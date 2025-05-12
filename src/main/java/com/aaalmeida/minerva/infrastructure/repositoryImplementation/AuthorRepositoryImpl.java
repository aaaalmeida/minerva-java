package com.aaalmeida.minerva.infrastructure.repositoryImplementation;

import com.aaalmeida.minerva.domain.exception.AlreadyExistingRelationshipException;
import com.aaalmeida.minerva.domain.exception.EntityNotFoundException;
import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
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
        authorNodeRepository.save(AuthorMapper.toEntity(author));
        return author;
    }

    @Override
    public Author followAuthor(UUID baseId, UUID targetId) {
        Author base = findById(baseId).orElseThrow(()-> new EntityNotFoundException(
                String.format("Author with id %s not found", baseId.toString())));

        Author target = findById(targetId).orElseThrow(()-> new EntityNotFoundException(
                String.format("Author with id %s not found", targetId.toString())));

        Boolean alreadyFollows = !base.followAuthor(target);

        if (alreadyFollows)
            throw new AlreadyExistingRelationshipException(
                    String.format("Author %s already follows Author %s",
                            baseId.toString(),
                            targetId.toString())
            );

        return save(base);
    }

    @Override
    public void unfollowAuthor(UUID baseId, UUID targetId) {
        Author base = findById(baseId).orElseThrow(()-> new EntityNotFoundException(
                String.format("Author with id %s not found", baseId.toString())));

        Author target = findById(targetId).orElseThrow(()-> new EntityNotFoundException(
                String.format("Author with id %s not found", targetId.toString())));

        base.unfollowAuthor(target);
        save(base);
    }

    @Override
    public Optional<Author> findById(UUID id) {
        return authorNodeRepository.findById(id).map(AuthorMapper::fromEntity);
    }

    @Override
    public Stream<Author> findByFirstName(String name) {
        return authorNodeRepository
                .findAuthorEntitiesByNameContainingIgnoreCase(name)
                .map(AuthorMapper::fromEntity);
    }

    @Override
    public Stream<Author> findByLastName(String lastName) {
        return authorNodeRepository
                .findAuthorEntitiesByLastNameContainingIgnoreCase(lastName)
                .map(AuthorMapper::fromEntity);
    }

    @Override
    public Stream<Author> findAll() {
        return authorNodeRepository
                .findAll()
                .stream().map(AuthorMapper::fromEntity);
    }

    @Override
    public void deleteById(UUID id) {
        authorNodeRepository.deleteById(id);
    }
}
