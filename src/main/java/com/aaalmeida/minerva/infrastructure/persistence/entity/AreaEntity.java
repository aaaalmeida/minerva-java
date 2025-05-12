package com.aaalmeida.minerva.infrastructure.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("AREA")
public class AreaEntity {
    @Id
    private UUID uuid;
    private String name;
    @Relationship(type = "SUPERIOR")
    private AreaEntity levelUp;
}
