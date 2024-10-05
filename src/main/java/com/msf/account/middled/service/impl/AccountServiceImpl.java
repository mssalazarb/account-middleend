package com.msf.account.middled.service.impl;

import com.msf.account.middled.client.AccountServiceClient;
import com.msf.account.middled.domain.Account;
import com.msf.account.middled.service.IAccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountServiceClient accountServiceClient;

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackCreateAccount")
    public Account createAccount(Account account) {
        return accountServiceClient
                .createAccount("wer", "wer", account).getBody();
    }

    private ResponseEntity<String> fallbackCreateAccount() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error creating account");
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "fallbackGettingAccount")
    public Account getAccountById(Long id) {
        return accountServiceClient.getAccountById("wer", "wer", id).getBody();
    }

    private ResponseEntity<String> fallbackGettingAccount() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error getting account");
    }
}
