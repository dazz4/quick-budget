package com.quickbudget.repository;

import com.quickbudget.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Override
    List<Account> findAll();

    @Override
    Optional<Account> findById(Long id);

    @Override
    Account save(Account account);

    @Override
    void deleteById(Long id);
}
