package com.aaalmeida.minerva.application.controller;

import com.aaalmeida.minerva.application.useCase.Author.*;
import com.aaalmeida.minerva.domain.model.Author;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AuthorController {
    private ListAllAuthorUseCase listAllAuthorUseCase;
    private CreateAuthorUseCase createAuthorUseCase;
    private FindAuthorByIdUseCase findAuthorByIdUseCase;
    private FindAuthorByNameUseCase findAuthorByNameUseCase;
    private FindAuthorByLastNameUseCase findAuthorByLastNameUseCase;
    private DeleteAuthorUseCase deleteAuthorUseCase;

    @GetMapping
    public List<Author> findAllAccount() {
        return listAllAuthorUseCase.execute();
    }

    @GetMapping("/id={accountID}")
    public Optional<Author> findAccountById(@PathVariable UUID accountID) {
        return findAuthorByIdUseCase.execute(accountID);
    }

    @GetMapping("/name={accountName}")
    public List<Author> findAccountByName(@PathVariable String accountName){
        return findAuthorByNameUseCase.execute(accountName);
    }

    @GetMapping("/lastname={accountLastName}")
    public List<Author> findAccountByLastName(@PathVariable String accountLastName){
        return findAuthorByLastNameUseCase.execute(accountLastName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAccount(@RequestBody Author author) {
        return createAuthorUseCase.execute(author);
    }

    @DeleteMapping("/{accountID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable UUID accountID) {
        deleteAuthorUseCase.execute(accountID);
    }
}
