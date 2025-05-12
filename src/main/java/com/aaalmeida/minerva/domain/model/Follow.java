package com.aaalmeida.minerva.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Follow {
    private UUID id;
    private LocalDate since;
    private UUID authorUuid;

    public Follow(UUID authorUuid) {
        this.id = UUID.randomUUID();
        this.since = LocalDate.now();
        this.authorUuid = authorUuid;
    }
}
