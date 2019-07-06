package com.quickbudget.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountDto {
    private Long id;
    private String name;
    private BigDecimal balance;
    private Budget budget;
    private List<Transaction> transactions = new ArrayList<>();
}
