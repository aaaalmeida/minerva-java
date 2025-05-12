package com.aaalmeida.minerva.domain.repository;

import com.aaalmeida.minerva.domain.model.Area;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface AreaRepository {
    Area save(Area area);
    Optional<Area> findById(UUID id);
    Stream<Area> findByName(String name);
    Stream<Area> findAll();
    void deleteById(UUID id);
}