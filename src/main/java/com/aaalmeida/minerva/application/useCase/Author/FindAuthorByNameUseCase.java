package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.factory.AuthorFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAuthorByNameUseCase {
    private AuthorRepository authorRepository;
    public List<AuthorDTO> execute(String accountName) {
        return authorRepository.findByFirstName(accountName)
                .map(AuthorFactory::toDTO)
                .toList();
    }
}
