package com.quickbudget.service;

import com.quickbudget.domain.Account;
import com.quickbudget.domain.Budget;
import com.quickbudget.repository.AccountRepository;
import com.quickbudget.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBService {
    @Autowired
    private BudgetRepository repository;
    @Autowired
    private AccountRepository accountRepository;

    public Budget saveBudget(final Budget budget) {
        return repository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return repository.findAll();
    }

    public Optional<Budget> getBudget(final Long id) {
        return repository.findById(id);
    }

    public void deleteBudget(final Long id) {
        repository.deleteById(id);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccount(final Long id) {
        return accountRepository.findById(id);
    }

    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    public Account saveAccount(final Account account) {
        return accountRepository.save(account);
    }
}
