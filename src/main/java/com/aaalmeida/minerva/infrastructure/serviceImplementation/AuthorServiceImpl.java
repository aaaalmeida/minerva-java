package com.aaalmeida.minerva.infrastructure.serviceImplementation;

import com.aaalmeida.minerva.domain.exception.AlreadyExistingRelationshipException;
import com.aaalmeida.minerva.domain.exception.EntityNotFoundException;
import com.aaalmeida.minerva.domain.service.AuthorService;
import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;
import com.aaalmeida.minerva.infrastructure.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    @Override
    public AuthorEntity save(AuthorEntity author) {
        return authorRepository.save(author);
    }

    @Override
    public AuthorEntity followAuthor(UUID baseId, UUID targetId) {
        AuthorEntity base = findById(baseId).orElseThrow(() -> new EntityNotFoundException(
                String.format("Author with id %s not found", baseId.toString())));

        AuthorEntity target = findById(targetId).orElseThrow(() -> new EntityNotFoundException(
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
    public Boolean unfollowAuthor(UUID baseId, UUID targetId) {
        AuthorEntity base = findById(baseId).orElseThrow(() -> new EntityNotFoundException(
                String.format("Author with id %s not found", baseId.toString())));

        AuthorEntity target = findById(targetId).orElseThrow(() -> new EntityNotFoundException(
                String.format("Author with id %s not found", targetId.toString())));

        base.unfollowAuthor(target);
        save(base);
        return Boolean.TRUE;
    }

    @Override
    public Optional<AuthorEntity> findById(UUID id) {
        return authorRepository.findById(id);
    }

    @Override
    public Stream<AuthorEntity> findByFirstName(String name) {
        return authorRepository.findAuthorEntitiesByNameContainingIgnoreCase(name);
    }

    @Override
    public Stream<AuthorEntity> findByLastName(String lastName) {
        return authorRepository.findAuthorEntitiesByLastNameContainingIgnoreCase(lastName);
    }

    @Override
    public Stream<AuthorEntity> findAll() {
        return authorRepository.findAll().stream();
    }

    @Override
    public void deleteById(UUID id) {
        authorRepository.deleteById(id);
    }
}
