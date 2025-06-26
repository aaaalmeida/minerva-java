package com.aaalmeida.minerva.domain.service;

import com.aaalmeida.minerva.infrastructure.entity.AreaEntity;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface AreaService {
    Optional<AreaEntity> findById(UUID id);

    Stream<AreaEntity> findByName(String name);

    Stream<AreaEntity> findAll();
}