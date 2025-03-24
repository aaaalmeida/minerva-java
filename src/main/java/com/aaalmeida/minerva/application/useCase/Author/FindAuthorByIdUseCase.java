package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FindAuthorByIdUseCase {
    private AuthorRepository authorRepository;

    public Optional<Author> execute(UUID id) {
        return authorRepository.findById(id);
    }
}
