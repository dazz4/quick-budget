package com.quickbudget.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.quickbudget.serializer.BudgetSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "BUDGETS")
@JsonSerialize(using = BudgetSerializer.class)
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "BUDGET_ID")
    private Long id;

    @Column(name = "BUDGET_NAME")
    private String name;

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "budget",
            cascade = CascadeType.MERGE,
            fetch = FetchType.LAZY
    )
    private List<Account> accounts = new ArrayList<>();
}
