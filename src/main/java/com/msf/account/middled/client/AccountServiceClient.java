package com.msf.account.middled.client;

import com.msf.account.middled.domain.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${microservices.url}/api/v1/account-service" , name = "accountServiceClient")
public interface AccountServiceClient {

    @PostMapping("/accounts")
    ResponseEntity<Account> createAccount(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                           @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                           @RequestBody Account account);

    @GetMapping("/accounts/{id}")
    ResponseEntity<Account> getAccountById(@RequestHeader(value = "x-sw-client-request-id", required = true) String xCmClientRequestId,
                                          @RequestHeader(value = "x-cm-client-user-agent", required = true) String xCmClientUserAgent,
                                          @PathVariable("id") Long id);
}
