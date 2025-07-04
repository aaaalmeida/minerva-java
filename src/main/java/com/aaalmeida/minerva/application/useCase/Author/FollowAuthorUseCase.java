package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.exception.InvalidRelationshipException;
import com.aaalmeida.minerva.domain.exception.InvalidUuidException;
import com.aaalmeida.minerva.domain.service.AuthorService;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.dto.FollowRequestDTO;
import com.aaalmeida.minerva.infrastructure.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FollowAuthorUseCase {
    private AuthorService authorRepository;

    public AuthorDTO execute(FollowRequestDTO followRequestDTO) {
        try {
            UUID baseUuid = UUID.fromString(followRequestDTO.baseId());
            UUID targetUuid = UUID.fromString(followRequestDTO.targetId());

            if (baseUuid.equals(targetUuid))
                throw new InvalidRelationshipException("An author cannot follow themself");

            return AuthorMapper.toDTO(authorRepository.followAuthor(baseUuid, targetUuid));
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException("Invalid UUID from follower or target");
        } catch (Exception e) {
            throw e;
        }
    }
}
