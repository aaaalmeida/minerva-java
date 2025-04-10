package com.aaalmeida.minerva.infrastructure.factory;

import com.aaalmeida.minerva.infrastructure.builder.AuthorBuilder;
import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class AuthorFactory {
    public static AuthorDTO toDTO(Author domain){
        return new AuthorDTO(
                domain.getUuid(),
                domain.getName(),
                domain.getMiddleName(),
                domain.getLastName(),
                domain.getEmail(),
                domain.getPassword(),
                domain.getUrl(),
                domain.getPhone(),
                domain.getIsRegistered(),
                domain.getFollows(),
                domain.getFollowedBy()
        );
    }

    public static Author fromDTO(AuthorDTO dto){
        return AuthorBuilder.builder()
                .name(dto.name())
                .middleName(dto.middleName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(dto.password())
                .url(dto.url())
                .phone(dto.phone())
                .build();
    }

    public static AuthorEntity toEntity(Author domain){
        return new AuthorEntity(
                domain.getUuid(),
                domain.getName(),
                domain.getMiddleName().orElse(null),
                domain.getLastName(),
                domain.getEmail(),
                domain.getPassword(),
                domain.getUrl().orElse(null),
                domain.getPhone().orElse(null),
                domain.getIsRegistered(),
                new ArrayList(domain.getFollows()),
                new ArrayList(domain.getFollowedBy())
        );
    }

    public static Author fromEntity(AuthorEntity entity){
        return AuthorBuilder.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .middleName(Optional.ofNullable(entity.getMiddleName()))
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .url(Optional.ofNullable(entity.getUrl()))
                .phone(Optional.ofNullable(entity.getPhone()))
                .isRegistered(entity.getIsRegistered())
                .follows(new HashSet(entity.getFollows()))
                .followedBy(new HashSet(entity.getFollowedBy()))
                .build();
    }
}
