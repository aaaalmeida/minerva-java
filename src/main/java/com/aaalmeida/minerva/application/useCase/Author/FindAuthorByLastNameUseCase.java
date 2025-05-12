package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAuthorByLastNameUseCase {
    private AuthorRepository authorRepository;
    public List<AuthorDTO> execute(String lastName) {
        return authorRepository.findByLastName(lastName)
                .map(AuthorMapper::toDTO)
                .toList();
    }
}
