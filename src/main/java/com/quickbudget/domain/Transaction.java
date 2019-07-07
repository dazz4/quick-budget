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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(
            targetEntity = Category.class,
            mappedBy = "transaction",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Category> categories = new ArrayList<>();
}
