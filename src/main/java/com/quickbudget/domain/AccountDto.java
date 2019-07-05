package com.quickbudget.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AccountDto {
    private Long id;
    private String name;
    private BigDecimal balance;
    @JsonBackReference
    private Budget budget;
    private List<Transaction> transactions = new ArrayList<>();
}
