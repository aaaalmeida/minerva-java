package com.aaalmeida.minerva.domain.repository;

import com.aaalmeida.minerva.domain.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AccountRepository {
    CompletableFuture<Account> save(Account account);
    CompletableFuture<Optional<Account>> findById(Long id);
    CompletableFuture<List<Account>> findByFirstName(String name);
    CompletableFuture<List<Account>> findByLastName(String name);
    CompletableFuture<List<Account>> findAll();
    void deleteById(Long id);
}
