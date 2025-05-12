package com.aaalmeida.minerva.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    private UUID uuid;
    private String name;
    private Optional<String> middleName;
    private String lastName;
    private String email;
    private String password;
    private Optional<String> url;
    private Optional<String> phone;
    private Boolean isRegistered;
    private List<Follow> follows;

    public Boolean followAuthor(Author target) {
        if (isFollower(target)) return false;

        return follows.add(new Follow(target.getUuid()));
    }

    public Boolean unfollowAuthor(Author target){
        if(!isFollower(target)) return false;

        return follows.remove(target);
    }

    private Boolean isFollower(Author author) {
        return follows.contains(author);
    }
}