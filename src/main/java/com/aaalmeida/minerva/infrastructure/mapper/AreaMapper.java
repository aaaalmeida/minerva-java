package com.aaalmeida.minerva.infrastructure.mapper;

import com.aaalmeida.minerva.infrastructure.dto.AreaDTO;
import com.aaalmeida.minerva.infrastructure.entity.AreaEntity;

public class AreaMapper {
    public static AreaDTO toDTO(AreaEntity entity) {
        return new AreaDTO(
                entity.getUuid(),
                entity.getName(),
//                TODO: fazer um shallow pra converter sem recursao
                null,
                null
        );
    }

    public static AreaEntity fromDTO(AreaDTO dto) {
        return new AreaEntity(
                dto.uuid(),
                dto.name(),
//                TODO
                null,
                null
        );
    }
}
