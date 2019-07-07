package com.quickbudget.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AccountDto {
    private Long id;
    private String name;
    private BigDecimal balance;
    private Budget budget;
    private List<Transaction> transactions;
}
