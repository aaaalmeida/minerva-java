package com.aaalmeida.minerva.infrastructure.dto;

import java.util.List;
import java.util.UUID;

public record AreaDTO(
        UUID uuid,
        String name,
        AreaDTO superior,
        List<AreaDTO> subareas
) {
}
