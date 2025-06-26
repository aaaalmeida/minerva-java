package com.aaalmeida.minerva.infrastructure.builder;

import com.aaalmeida.minerva.infrastructure.entity.AuthorEntity;
import com.aaalmeida.minerva.infrastructure.entity.FollowEntity;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
public class AuthorBuilder {
    private UUID uuid;
    private String name;
    private String middleName;
    private String lastName;
    private String email;
    private String password;
    private String url;
    private String phone;
    // TODO: criar logica para autores cadastrados
    private Boolean isRegistered = false;
    private Set<FollowEntity> follows = new HashSet<>();

    public static AuthorBuilder builder() {
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

    public AuthorBuilder middleName(String middleName) {
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

    public AuthorBuilder url(String url) {
        this.url = url;
        return this;
    }

    public AuthorBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public AuthorBuilder isRegistered(Boolean isRegistered) {
        this.isRegistered = isRegistered;
        return this;
    }

    public AuthorBuilder follows(Set<FollowEntity> follows) {
        this.follows = follows;
        return this;
    }

    public AuthorEntity build() {
        return new AuthorEntity(
                uuid,
                name,
                lastName,
                email,
                password,
                follows,
                middleName,
                url,
                phone
        );
    }
}