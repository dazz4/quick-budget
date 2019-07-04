package com.quickbudget.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "BUDGETS")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "budget",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Account> accounts = new ArrayList<>();

    public Budget(String name) {
        this.name = name;
    }
}
