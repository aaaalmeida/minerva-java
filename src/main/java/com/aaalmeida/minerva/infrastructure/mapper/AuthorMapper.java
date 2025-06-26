package com.aaalmeida.minerva.infrastructure.mapper;

import com.aaalmeida.minerva.infrastructure.builder.AuthorBuilder;
import com.aaalmeida.minerva.infrastructure.dto.AuthorDTO;
import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;

import java.util.Set;

public class AuthorMapper {
    public static AuthorDTO toDTO(AuthorEntity author) {
        return new AuthorDTO(
                author.getId(),
                author.getName(),
                author.getMiddleName(),
                author.getLastName(),
                author.getEmail(),
                author.getPassword(),
                author.getUrl(),
                author.getPhone(),
//                TODO
                null
        );
    }

    public static AuthorEntity fromDTO(AuthorDTO dto) {
        return AuthorBuilder.builder()
                .uuid(dto.uuid())
                .name(dto.name())
                .middleName(dto.middleName())
                .lastName(dto.lastName())
                .email(dto.email())
                .password(dto.password())
                .url(dto.url())
                .phone(dto.phone())
//                TODO
                .follows(Set.of())
                .build();
    }
}
