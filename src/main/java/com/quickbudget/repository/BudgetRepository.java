package com.quickbudget.repository;

import com.quickbudget.domain.Budget;
import org.springframework.data.repository.CrudRepository;

public interface BudgetRepository extends CrudRepository<Budget, Long> {
    @Override
    Budget save(Budget budget);
}
