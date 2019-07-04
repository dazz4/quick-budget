package com.quickbudget.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    @ManyToOne
    @JoinColumn(name = "account_id")
    public Account account;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    public Category category;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "payee")
    private String payee;

    @Column(name = "outflow")
    private BigDecimal outflow;

    @Column(name = "inflow")
    private BigDecimal inflow;

    public Transaction(String name, LocalDate date, String payee,
                       BigDecimal outflow, BigDecimal inflow) {
        this.name = name;
        this.date = date;
        this.payee = payee;
        this.outflow = outflow;
        this.inflow = inflow;
    }
}
