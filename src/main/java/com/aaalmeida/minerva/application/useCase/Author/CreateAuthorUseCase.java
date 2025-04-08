package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import com.aaalmeida.minerva.infrastructure.factory.AuthorFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAuthorUseCase {
    private AuthorRepository authorRepository;
    public AuthorDTO execute(AuthorDTO dto) {
        Author author = AuthorFactory.fromDTO(dto);
        return AuthorFactory.toDTO(authorRepository.save(author));
    }
}
