package com.aaalmeida.minerva.infrastructure.serviceImplementation;

import com.aaalmeida.minerva.domain.service.AreaService;
import com.aaalmeida.minerva.infrastructure.entity.AreaEntity;
import com.aaalmeida.minerva.infrastructure.repository.AreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class AreaServiceImpl implements AreaService {
    private AreaRepository areaRepository;

    @Override
    public Optional<AreaEntity> findById(UUID id) {
        return areaRepository.findById(id);
    }

    @Override
    public Stream<AreaEntity> findByName(String name) {
        return areaRepository.findByNameContaining(name);
    }

    @Override
    public Stream<AreaEntity> findAll() {
        return areaRepository.findAll().stream();
    }
}
