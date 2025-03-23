package com.aaalmeida.minerva.infrastructure.repositoryImplementation;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import com.aaalmeida.minerva.infrastructure.mapper.AccountMapper;
import com.aaalmeida.minerva.infrastructure.repository.AccountNodeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private AccountNodeRepository accountNodeRepository;
    private AccountMapper accountMapper;

    @Override
    public Account save(Account account) {
        accountNodeRepository.save(accountMapper.toEntity(account));
        return account;
    }

    @Override
    public Optional<Account> findById(UUID id) {
        return accountNodeRepository.findById(id).map(accountMapper::toDomain);
    }

    @Override
    public List<Account> findByFirstName(String name) {
        return accountNodeRepository
                .findAccountEntitiesByNameContainingIgnoreCase(name)
                .map(accountMapper::toDomain)
                .toList();
    }

    @Override
    public List<Account> findByLastName(String lastName) {
        return accountNodeRepository
                .findAccountEntitiesByLastNameContainingIgnoreCase(lastName)
                .map(accountMapper::toDomain)
                .toList();
    }

    @Override
    public List<Account> findAll() {
        return accountNodeRepository
                .findAll()
                .stream().map(accountMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(UUID id) {
        accountNodeRepository.deleteById(id);
    }
}
