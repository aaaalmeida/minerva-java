package com.aaalmeida.minerva.infrastructure.builder;

import com.aaalmeida.minerva.domain.model.Author;
import com.aaalmeida.minerva.domain.model.Follow;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public class AuthorBuilder {
    // builder gera id unico caso não seja previamente informado
    private UUID uuid = UUID.randomUUID();
    private String name;
    private Optional<String> middleName = Optional.empty();
    private String lastName;
    private String email;
    private String password;
    private Optional<String> url = Optional.empty();
    private Optional<String> phone = Optional.empty();
    // TODO: criar logica para autores cadastrados
    private Boolean isRegistered = false;
    private Set<Follow> follows = new HashSet<>();
    private Set<Follow> followedBy = new HashSet<>();

    private AuthorBuilder(){}

    public static AuthorBuilder builder(){
        return new AuthorBuilder();
    }

    public AuthorBuilder uuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    public AuthorBuilder name(String name) {
        this.name = name;
        return this;
    }

    public AuthorBuilder middleName(Optional<String> middleName) {
        this.middleName = middleName;
        return this;
    }

    public AuthorBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AuthorBuilder email(String email) {
        this.email = email;
        return this;
    }

    public AuthorBuilder password(String password) {
        this.password = password;
        return this;
    }

    public AuthorBuilder url(Optional<String> url) {
        this.url = url;
        return this;
    }

    public AuthorBuilder phone(Optional<String> phone) {
        this.phone = phone;
        return this;
    }

    public AuthorBuilder isRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
        return this;
    }

    public AuthorBuilder follows(Set<Follow> follows) {
        this.follows = follows;
        return this;
    }

    public AuthorBuilder followedBy(Set<Follow> followedBy) {
        this.followedBy = followedBy;
        return this;
    }

    public Author build(){
        return new Author(
                uuid,
                name,
                middleName,
                lastName,
                email,
                password,
                url,
                phone,
                isRegistered,
                follows,
                followedBy
        );
    }
}