package com.aaalmeida.minerva.application.useCase.Area;

import com.aaalmeida.minerva.domain.exception.EntityNotFoundException;
import com.aaalmeida.minerva.domain.exception.InvalidUuidException;
import com.aaalmeida.minerva.domain.service.AreaService;
import com.aaalmeida.minerva.infrastructure.dto.AreaDTO;
import com.aaalmeida.minerva.infrastructure.mapper.AreaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FindAreaByIdUseCase {
    private final AreaService service;

    public AreaDTO execute(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return service.findById(uuid)
                    .map(AreaMapper::toDTO)
                    .orElseThrow(
                            () -> new EntityNotFoundException(
                                    String.format("Area with %s not found", id)));
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidException(id + " is not a valid UUID");
        }
    }
}
