package com.aaalmeida.minerva.infrastructure.repository;

import com.aaalmeida.minerva.infrastructure.entity.AccountEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AccountNodeRepository extends ReactiveNeo4jRepository<AccountEntity, Long> {
    Flux<AccountEntity> findAccountEntityByNameContainsIgnoreCase(String name);
    Flux<AccountEntity> findAccountEntitiesByLastNameContainsIgnoreCase(String lastName);
}
