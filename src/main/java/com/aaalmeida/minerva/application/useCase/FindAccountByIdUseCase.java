package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FindAccountByIdUseCase {
    private AccountRepository accountRepository;

    public Optional<Account> execute(UUID id) {
        return accountRepository.findById(id);
    }
}
