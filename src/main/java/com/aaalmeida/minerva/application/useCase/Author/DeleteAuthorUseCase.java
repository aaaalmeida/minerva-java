package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteAuthorUseCase {
    private AuthorRepository authorRepository;
    public void execute(UUID id) {
        authorRepository.deleteById(id);
    }
}
