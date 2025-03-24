package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAuthorUseCase {
    private AuthorRepository authorRepository;
    public Author execute(Author author) {
        return authorRepository.save(author);
    }
}
