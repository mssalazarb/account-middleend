package com.msf.account.middled.service.impl;

import com.msf.account.middled.client.AccountServiceClient;
import com.msf.account.middled.domain.Account;
import com.msf.account.middled.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private final AccountServiceClient accountServiceClient;

    @Override
    public Account createAccount(Account account) {
        return accountServiceClient
                .createAccount("wer", "wer", account).getBody(); // son los headers que debemos poner
        // si van nulos no funciona
    }

    @Override
    public Account updateAccount(Account account) {
        Long accountId = account.getId();
        return accountServiceClient.updateAccount("wer","wer",accountId,account).getBody();
    }
}
