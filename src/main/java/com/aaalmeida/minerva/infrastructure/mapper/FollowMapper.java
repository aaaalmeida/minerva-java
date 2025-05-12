package com.aaalmeida.minerva.infrastructure.mapper;

import com.aaalmeida.minerva.domain.model.Follow;
import com.aaalmeida.minerva.infrastructure.persistence.relationship.FollowRelationship;

public class FollowMapper {
    public static Follow toDomain(FollowRelationship relationship) {
        return new Follow(
                relationship.getUuid(),
                relationship.getSince(),
                relationship.getAuthorUuid()
        );
    }

    public static FollowRelationship toEntity(Follow follow) {
        return new FollowRelationship(
          follow.getAuthorUuid(),
          follow.getSince(),
          follow.getAuthorUuid()
        );
    }
}
