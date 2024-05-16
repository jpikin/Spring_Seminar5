package com.example.example1_sem5.controller;

import com.example.example1_sem5.model.Account;
import com.example.example1_sem5.model.dto.TransferRequest;
import com.example.example1_sem5.service.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class AccountController {
    private final TransferService service;

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest transferRequest){

        service.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/account")
    public Iterable<Account> getAllAccounts(){
        return service.getAllAccounts();
    }
}
