package com.quickbudget.service;

import com.quickbudget.domain.Budget;
import com.quickbudget.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {
    @Autowired
    private BudgetRepository repository;

    public Budget saveBudget(final Budget budget) {
        return repository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return repository.findAll();
    }
}
