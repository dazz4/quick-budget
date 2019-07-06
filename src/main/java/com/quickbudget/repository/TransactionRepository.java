package com.quickbudget.repository;

import com.quickbudget.domain.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Override
    Transaction save(Transaction transaction);

    @Override
    Optional<Transaction> findById(Long aLong);

    @Override
    List<Transaction> findAll();

    @Override
    void deleteById(Long id);
}
