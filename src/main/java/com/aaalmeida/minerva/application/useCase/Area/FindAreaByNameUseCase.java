package com.aaalmeida.minerva.application.useCase.Area;

import com.aaalmeida.minerva.domain.service.AreaService;
import com.aaalmeida.minerva.infrastructure.dto.AreaDTO;
import com.aaalmeida.minerva.infrastructure.mapper.AreaMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAreaByNameUseCase {
    private final AreaService areaService;

    public List<AreaDTO> execute(String name) {
        return areaService.findByName(name).map(AreaMapper::toDTO).toList();
    }
}
