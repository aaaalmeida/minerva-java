package com.aaalmeida.minerva.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
//@NoArgsConstructor
public class Follow {
    private UUID id;
    private LocalDate since;
    private Author target;

    public Follow(Author target) {
        this.id = UUID.randomUUID();
        this.since = LocalDate.now();
        this.target = target;
    }
}
