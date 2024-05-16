package com.example.example1_sem5.service;

import com.example.example1_sem5.exeptions.AccountNotFoundException;
import com.example.example1_sem5.model.Account;
import com.example.example1_sem5.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class TransferService {
    private final AccountRepository accountRepository;

    public void transferMoney(long senderId, long receiverId, BigDecimal amount){
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(AccountNotFoundException::new);

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(AccountNotFoundException::new);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(senderId, senderNewAmount);
        accountRepository.changeAmount(receiverId, receiverNewAmount);
    }
    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public List<Account> findAccountByName(String name){
        return accountRepository.findAccountByName(name);
    }
}
