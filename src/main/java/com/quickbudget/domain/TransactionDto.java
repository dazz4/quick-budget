package com.quickbudget.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TransactionDto {
    private Long id;
    private String name;
    private LocalDate date;
    private String payee;
    private BigDecimal outflow;
    private BigDecimal inflow;
    private Account account;
    private List<Category> categories;
}
