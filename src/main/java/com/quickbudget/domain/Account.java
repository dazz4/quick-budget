package com.quickbudget.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.quickbudget.serializer.AccountSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "ACCOUNTS")
@JsonSerialize(using = AccountSerializer.class)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ACCOUNT_ID")
    private Long id;

    @Column(name = "ACCOUNT_NAME")
    private String name;

    @Column(name = "BALANCE")
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "BUDGET_ID")
    private Budget budget;

    @OneToMany(
            targetEntity = Transaction.class,
            mappedBy = "account",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Transaction> transactions = new ArrayList<>();
}
