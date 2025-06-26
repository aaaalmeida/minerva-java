package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.service.AuthorService;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAuthorByNameUseCase {
    private AuthorService authorRepository;

    public List<AuthorDTO> execute(String accountName) {
        return authorRepository.findByFirstName(accountName)
                .map(AuthorMapper::toDTO)
                .toList();
    }
}
