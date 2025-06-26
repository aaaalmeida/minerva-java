package com.aaalmeida.minerva.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "area")
public class AreaEntity {
    @Id
    private UUID uuid;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "superior_id")
    private AreaEntity superior;

    @OneToMany(mappedBy = "superior", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AreaEntity> subareas;
}
