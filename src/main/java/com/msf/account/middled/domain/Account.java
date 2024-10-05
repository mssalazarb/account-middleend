package com.msf.account.middled.domain;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Account {
    private Long id;
    private String numberAccount;
    private Integer currencyType;
    private BigDecimal amount;
    private Integer customerId;
}
