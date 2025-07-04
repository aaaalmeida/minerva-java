package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.exception.EntityNotFoundException;
import com.aaalmeida.minerva.domain.exception.InvalidUuidException;
import com.aaalmeida.minerva.domain.service.AuthorService;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FindAuthorByIdUseCase {
    private AuthorService authorService;

    public AuthorDTO execute(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return authorService.findById(uuid)
                    .map(AuthorMapper::toDTO)
                    .orElseThrow(
                            () -> new EntityNotFoundException(
                                    String.format("Author with %s not found", id)));
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException(id + " is not a valid UUID");
        }
    }
}
