package com.javalearning.Banking_app.service.Impl;

import com.javalearning.Banking_app.dto.AccountDto;
import com.javalearning.Banking_app.entity.Account;
import com.javalearning.Banking_app.mapper.AccountMapper;
import com.javalearning.Banking_app.repository.AccountRepository;
import com.javalearning.Banking_app.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account Does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account Does not exist"));

        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Account Does not exist"));
        if (account.getBalance() < amount){
            throw new RuntimeException("withdraw amount is more than balance amount");
    }
            double total= account.getBalance()-amount;
           account.setBalance(total);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
