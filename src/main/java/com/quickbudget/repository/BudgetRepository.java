package com.quickbudget.repository;

import com.quickbudget.domain.Budget;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BudgetRepository extends CrudRepository<Budget, Long> {
    @Override
    List<Budget> findAll();

    @Override
    Budget save(Budget budget);
}
