package com.aaalmeida.minerva.infrastructure.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FollowDTO(
        UUID id,
        LocalDate since,
        AuthorDTO authorDTO
) {
}
