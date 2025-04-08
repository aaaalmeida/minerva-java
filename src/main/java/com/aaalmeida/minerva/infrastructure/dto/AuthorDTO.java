package com.aaalmeida.minerva.infrastructure.dto;

import com.aaalmeida.minerva.domain.model.Follow;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public record AuthorDTO(
        UUID id,
        String name,
        Optional<String> middleName,
        String lastName,
        String email,
        String password,
        Optional<String> url,
        Optional<String> phone,
        Boolean isRegistered,
        Set<Follow> follows,
        Set<Follow> followedBy
) {

}
