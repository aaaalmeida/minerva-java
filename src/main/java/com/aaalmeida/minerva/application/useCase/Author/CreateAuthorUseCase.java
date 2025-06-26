package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.service.AuthorService;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAuthorUseCase {
    private final AuthorService authorauthorService;

    public AuthorDTO execute(AuthorDTO dto) {
        AuthorEntity author = AuthorMapper.fromDTO(dto);
        return AuthorMapper.toDTO(authorauthorService.save(author));
    }
}
