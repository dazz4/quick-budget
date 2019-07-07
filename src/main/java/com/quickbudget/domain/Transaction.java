package com.quickbudget.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.quickbudget.serializer.TransactionSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "TRANSACTIONS")
@JsonSerialize(using = TransactionSerializer.class)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "TRANSACTION_ID")
    private Long id;

    @Column(name = "TRANSACTION_NAME")
    private String name;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "PAYEE")
    private String payee;

    @Column(name = "OUTFLOW")
    private BigDecimal outflow;

    @Column(name = "INFLOW")
    private BigDecimal inflow;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "JOIN_TRANSACTION_CATEGORY",
            joinColumns = {@JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "TRANSACTION_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")}
    )
    private List<Category> categories = new ArrayList<>();
}
