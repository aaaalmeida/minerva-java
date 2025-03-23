package com.aaalmeida.minerva.application.useCase;

import com.aaalmeida.minerva.domain.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteAccountUseCase {
    private AccountRepository accountRepository;
    public void execute(UUID id) {
        accountRepository.deleteById(id);
    }
}
