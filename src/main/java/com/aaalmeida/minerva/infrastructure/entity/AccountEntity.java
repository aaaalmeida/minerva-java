package com.aaalmeida.minerva.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
@Node("Account")
public class AccountEntity {
    @Id @GeneratedValue
    private final Long id;
    private String name;
    private Optional<String> middleName;
    private String lastName;
    private final String email;
    private String password;
    private Optional<String> url;
    private Optional<String> phone;
    private Boolean isRegistered;
    @Relationship(type = "FOLLOW")
    private Set<AccountEntity> follows;
}
