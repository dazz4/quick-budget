package com.quickbudget.service;

import com.quickbudget.domain.Account;
import com.quickbudget.domain.Budget;
import com.quickbudget.domain.Category;
import com.quickbudget.domain.Transaction;
import com.quickbudget.repository.AccountRepository;
import com.quickbudget.repository.BudgetRepository;
import com.quickbudget.repository.CategoryRepository;
import com.quickbudget.repository.TransactionRepository;
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
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CategoryRepository categoryRepository;

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

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransaction(final Long id) {
        return transactionRepository.findById(id);
    }

    public void deleteTransaction(final Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction saveTransaction(final Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(final Long id) {
        return categoryRepository.findById(id);
    }

    public void deleteCategory(final Long id) {
        categoryRepository.deleteById(id);
    }

    public Category saveCategory(final Category category) {
        return categoryRepository.save(category);
    }
}
