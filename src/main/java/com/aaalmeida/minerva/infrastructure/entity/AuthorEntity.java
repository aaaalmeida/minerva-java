package com.aaalmeida.minerva.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "author")
public class AuthorEntity {
    @Id
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "author")
    private Set<FollowEntity> follows;

    @Column(nullable = true)
    private String middleName;
    @Column(nullable = true)
    private String url;
    @Column(nullable = true)
    private String phone;


    public Boolean followAuthor(AuthorEntity target) {
        return follows.add(new FollowEntity(
                UUID.randomUUID(),
                LocalDate.now(),
                target
        ));
    }

    public Boolean unfollowAuthor(AuthorEntity target) {
        return follows.remove(target);
    }
}
