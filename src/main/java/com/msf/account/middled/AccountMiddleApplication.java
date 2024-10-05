package com.msf.account.middled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountMiddleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountMiddleApplication.class, args);
    }

}
