package com.quickbudget.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            targetEntity = Account.class,
            mappedBy = "budget",
            fetch = FetchType.LAZY
    )
    @JsonManagedReference
    private List<Account> accounts = new ArrayList<>();
}
