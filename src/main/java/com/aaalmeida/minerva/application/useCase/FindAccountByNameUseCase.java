package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAccountByNameUseCase {
    private AccountRepository accountRepository;
    public List<Account> execute(String accountName) {
        return accountRepository.findByFirstName(accountName);
    }
}
