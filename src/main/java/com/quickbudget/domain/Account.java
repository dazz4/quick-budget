package com.quickbudget.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private Budget budget;

    @OneToMany(
            targetEntity = Transaction.class,
            mappedBy = "account",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Transaction> transactions = new ArrayList<>();

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }
}
