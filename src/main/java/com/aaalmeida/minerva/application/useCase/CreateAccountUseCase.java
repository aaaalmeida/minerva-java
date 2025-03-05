package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CreateAccountUseCase {
    private AccountRepository accountRepository;
    public CompletableFuture<?> execute() {

    }
}
