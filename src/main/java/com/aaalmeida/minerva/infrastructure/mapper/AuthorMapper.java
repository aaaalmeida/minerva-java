package com.aaalmeida.minerva.infrastructure.mapper;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorEntity toEntity(Author author);
    Author toDomain(AuthorEntity author);
}
