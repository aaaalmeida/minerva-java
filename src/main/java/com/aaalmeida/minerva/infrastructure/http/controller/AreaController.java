package com.aaalmeida.minerva.infrastructure.http.controller;

import com.aaalmeida.minerva.application.useCase.Area.FindAreaByIdUseCase;
import com.aaalmeida.minerva.application.useCase.Area.FindAreaByNameUseCase;
import com.aaalmeida.minerva.application.useCase.Area.ListAllAreaUseCase;
import com.aaalmeida.minerva.infrastructure.dto.AreaDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController("/area")
public class AreaController {
    private final ListAllAreaUseCase listAllAreaUseCase;
    private final FindAreaByIdUseCase findAreaByIdUseCase;
    private final FindAreaByNameUseCase findAreaByNameUseCase;

    @GetMapping
    public ResponseEntity<List<AreaDTO>> findAllAreas() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(listAllAreaUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaDTO> findAreaById(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(findAreaByIdUseCase.execute(id));
    }

    @GetMapping("/name={name}")
    public ResponseEntity<List<AreaDTO>> findAreaByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(findAreaByNameUseCase.execute(name));
    }
}
