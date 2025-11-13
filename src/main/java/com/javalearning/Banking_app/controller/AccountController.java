package com.javalearning.Banking_app.controller;

import com.javalearning.Banking_app.dto.AccountDto;
import com.javalearning.Banking_app.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    private AccountService accountService;

    //add account using REST
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    //Get account by id
    @GetMapping("{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    //depost amount to existing account Rest api
    @PutMapping("{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,
                                              @RequestBody Map<String, Double> request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);

    }
    //withdraw amount from balance account rest api
    @PutMapping("{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String,Double>request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);

    }

    //Get All accouts Rest api
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts=accountService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }

    //delete account rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Account deleted");
    }
}
