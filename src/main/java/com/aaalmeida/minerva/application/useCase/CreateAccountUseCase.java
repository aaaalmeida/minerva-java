package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateAccountUseCase {
    private AccountRepository accountRepository;
    public Account execute(Account account) {
        return accountRepository.save(account);
    }
}
