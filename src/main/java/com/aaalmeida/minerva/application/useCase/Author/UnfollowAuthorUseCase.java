package com.aaalmeida.minerva.application.useCase.Author;

import com.aaalmeida.minerva.domain.exception.InvalidUuidException;
import com.aaalmeida.minerva.domain.service.AuthorService;
import com.aaalmeida.minerva.infrastructure.dto.FollowRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UnfollowAuthorUseCase {
    private AuthorService authorRepository;

    public Boolean execute(FollowRequestDTO followRequestDTO) {
        try {
            UUID baseUuid = UUID.fromString(followRequestDTO.baseId());
            UUID targetUuid = UUID.fromString(followRequestDTO.targetId());

            return authorRepository.unfollowAuthor(baseUuid, targetUuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException("Invalid UUID from follower or target");
        } catch (Exception e) {
            throw e;
        }
    }
}
