package com.aaalmeida.minerva.application.controller;

import com.aaalmeida.minerva.application.useCase.CreateAccountUseCase;
import com.aaalmeida.minerva.application.useCase.ListAllAccountUseCase;
import com.aaalmeida.minerva.domain.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private ListAllAccountUseCase listAllAccountUseCase;
    private CreateAccountUseCase createAccountUseCase;

    //    @GetMapping("/{accountID}")
//    public Account findAccount(Long accountID) {
//        return
//    }

    @GetMapping
    public List<Account> findAllAccount() {
        return listAllAccountUseCase.execute();
    }

    @GetMapping("/{accountID}")
    public Account findAccountById(Long accountID) {
        return
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody) {

    }
}
