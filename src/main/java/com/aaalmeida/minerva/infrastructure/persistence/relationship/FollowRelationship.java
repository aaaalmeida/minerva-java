package com.aaalmeida.minerva.infrastructure.persistence.relationship;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class FollowRelationship {
    @Id
    private UUID uuid;
    private LocalDate since;
    @TargetNode
    private UUID authorUuid;
}
