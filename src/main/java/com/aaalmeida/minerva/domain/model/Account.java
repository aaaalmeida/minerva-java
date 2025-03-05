package com.aaalmeida.minerva.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
public class Account {
    private final Long id;
    private String name;
    private Optional<String> middleName;
    private String lastName;
    private final String email;
    private String password;
    private Optional<String> url;
    private Optional<String> phone;
    private Boolean isRegistered;
    private Set<Account> follows;
}
