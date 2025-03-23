package com.aaalmeida.minerva.domain.repository;

import com.aaalmeida.minerva.domain.model.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    List<Account> findByFirstName(String name);
    List<Account> findByLastName(String lastName);
    List<Account> findAll();
    void deleteById(UUID id);
}
