package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListAllAuthorUseCase {
    private AuthorRepository authorRepository;
    public List<Author> execute() {
        return authorRepository.findAll();
    }
}
