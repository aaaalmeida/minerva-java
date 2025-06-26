package com.aaalmeida.minerva.infrastructure.repository;

import com.aaalmeida.minerva.infrastructure.entity.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface AreaRepository extends JpaRepository<AreaEntity, UUID> {
    Stream<AreaEntity> findByNameContaining(String name);
}
