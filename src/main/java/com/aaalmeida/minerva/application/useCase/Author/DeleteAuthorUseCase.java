package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.exception.InvalidUuidException;
import com.aaalmeida.minerva.domain.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteAuthorUseCase {
    private AuthorRepository authorRepository;
    public void execute(String id) {
        try{
            UUID uuid = UUID.fromString(id);
            authorRepository.deleteById(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException(id + " is not a valid id");
        }
    }
}
