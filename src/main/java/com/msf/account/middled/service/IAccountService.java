package com.msf.account.middled.service;

/*aqui va como si fuera el contrato*/
import com.msf.account.middled.domain.Account;

public interface IAccountService {
    Account createAccount(Account account);
    Account getAccountById(Long id);
}

