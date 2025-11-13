package com.javalearning.Banking_app.service;

import com.javalearning.Banking_app.dto.AccountDto;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto withdraw(Long id,double amount);
    List<AccountDto> getAllAccount();
    void deleteAccountById(Long id);
}
