package com.aaalmeida.minerva.infrastructure.dto;

import com.aaalmeida.minerva.domain.model.Area;

import java.util.Optional;
import java.util.UUID;

public record AreaDTO(
        UUID uuid,
        String name,
        Optional<Area> levelUp
) {
}
