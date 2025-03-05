package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.model.Account;
import com.aaalmeida.minerva.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class FindAccountByIdUseCase {
    private AccountRepository accountRepository;
    public Account execute(Long id) {
        return accountRepository.findById(id);
    }
}
