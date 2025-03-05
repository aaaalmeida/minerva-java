package com.aaalmeida.minerva.infrastructure.repositoryImplementation;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import com.aaalmeida.minerva.infrastructure.mapper.AccountMapper;
import com.aaalmeida.minerva.infrastructure.repository.AccountNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private AccountNodeRepository accountNodeRepository;
    private AccountMapper accountMapper;

    @Override
    public CompletableFuture<Account> save(Account account) {
        return accountNodeRepository.save(accountMapper.toEntity(account))
                .map(accountMapper::toDomain)
                .toFuture();
    }

    @Override
    public CompletableFuture<Optional<Account>> findById(Long id) {
        return accountNodeRepository.findById(id)
                .map(accountMapper::toDomain)
                .map(Optional::ofNullable)
                .toFuture();
    }

    @Override
    public CompletableFuture<List<Account>> findByFirstName(String name) {
        return accountNodeRepository.findAccountEntityByNameContainsIgnoreCase(name)
                .map(accountMapper::toDomain)
                .collectList()
                .toFuture();
    }

    @Override
    public CompletableFuture<List<Account>> findByLastName(String name) {
        return accountNodeRepository.findAccountEntitiesByLastNameContainsIgnoreCase(name)
                .map(accountMapper::toDomain)
                .collectList()
                .toFuture();
    }

    @Override
    public CompletableFuture<List<Account>> findAll() {
        return accountNodeRepository.findAll()
                .map(accountMapper::toDomain)
                .collectList()
                .toFuture();
    }

    @Override
    public void deleteById(Long id) {
        accountNodeRepository.deleteById(id);
    }
}
