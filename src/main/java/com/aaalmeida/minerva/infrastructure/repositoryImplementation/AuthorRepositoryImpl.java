package com.aaalmeida.minerva.infrastructure.repositoryImplementation;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
import com.aaalmeida.minerva.infrastructure.repository.AuthorNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class AuthorRepositoryImpl implements AuthorRepository {
    private AuthorNodeRepository authorNodeRepository;
    private AuthorMapper authorMapper;

    @Override
    public Author save(Author author) {
        authorNodeRepository.save(authorMapper.toEntity(author));
        return author;
    }

    @Override
    public Optional<Author> findById(UUID id) {
        return authorNodeRepository.findById(id).map(authorMapper::toDomain);
    }

    @Override
    public List<Author> findByFirstName(String name) {
        return authorNodeRepository
                .findAuthorEntitiesByNameContainingIgnoreCase(name)
                .map(authorMapper::toDomain)
                .toList();
    }

    @Override
    public List<Author> findByLastName(String lastName) {
        return authorNodeRepository
                .findAuthorEntitiesByLastNameContainingIgnoreCase(lastName)
                .map(authorMapper::toDomain)
                .toList();
    }

    @Override
    public List<Author> findAll() {
        return authorNodeRepository
                .findAll()
                .stream().map(authorMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        authorNodeRepository.deleteById(id);
    }
}
