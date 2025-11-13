package com.javalearning.Banking_app.service;

import com.javalearning.Banking_app.dto.AccountDto;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id,double amount);
}
