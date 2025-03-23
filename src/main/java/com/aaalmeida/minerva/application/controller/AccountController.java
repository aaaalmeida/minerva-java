package com.aaalmeida.minerva.application.controller;

import com.aaalmeida.minerva.application.useCase.*;
import com.aaalmeida.minerva.domain.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
    private ListAllAccountUseCase listAllAccountUseCase;
    private CreateAccountUseCase createAccountUseCase;
    private FindAccountByIdUseCase findAccountByIdUseCase;
    private FindAccountByNameUseCase findAccountByNameUseCase;
    private FindAccountByLastNameUseCase findAccountByLastNameUseCase;
    private DeleteAccountUseCase deleteAccountUseCase;

    @GetMapping
    public List<Account> findAllAccount() {
        return listAllAccountUseCase.execute();
    }

    @GetMapping("/id={accountID}")
    public Optional<Account> findAccountById(@PathVariable UUID accountID) {
        return findAccountByIdUseCase.execute(accountID);
    }

    @GetMapping("/name={accountName}")
    public List<Account> findAccountByName(@PathVariable String accountName){
        return findAccountByNameUseCase.execute(accountName);
    }

    @GetMapping("/lastname={accountLastName}")
    public List<Account> findAccountByLastName(@PathVariable String accountLastName){
        return findAccountByLastNameUseCase.execute(accountLastName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return createAccountUseCase.execute(account);
    }

    @DeleteMapping("/{accountID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable UUID accountID) {
        deleteAccountUseCase.execute(accountID);
    }
}
