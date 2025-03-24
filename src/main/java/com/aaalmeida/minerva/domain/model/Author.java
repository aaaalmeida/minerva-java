package com.aaalmeida.minerva.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private UUID id;
    private String name;
    private Optional<String> middleName;
    private String lastName;
    private String email;
    private String password;
    private Optional<String> url;
    private Optional<String> phone;
    private Boolean isRegistered;

    private Set<Author> follows;

}
