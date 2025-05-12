package com.aaalmeida.minerva.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private UUID uuid;
    private String name;
    private Optional<Area> levelUp;
}
