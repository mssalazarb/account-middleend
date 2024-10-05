package com.msf.account.middled.controller;

import com.msf.account.middled.domain.Account;
import com.msf.account.middled.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService iAccountService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        return new ResponseEntity<>(iAccountService.createAccount(account), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<Account> getAccountById(@PathVariable("id") Long id){
        return new ResponseEntity<>(iAccountService.getAccountById(id), HttpStatus.CREATED);
    }
}
