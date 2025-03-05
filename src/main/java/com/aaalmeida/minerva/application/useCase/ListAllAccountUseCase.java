package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllAccountUseCase {
    private AccountRepository accountRepository;
    public List<Account> execute() {
        return accountRepository.findAll()
                .handleAsync((result, exception) -> {
                    return result;
                });
    }
}
