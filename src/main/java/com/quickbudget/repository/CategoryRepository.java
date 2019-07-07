package com.quickbudget.repository;

import com.quickbudget.domain.Account;
import com.quickbudget.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    @Override
    List<Category> findAll();

    @Override
    Optional<Category> findById(Long id);

    @Override
    Category save(Category category);

    @Override
    void deleteById(Long id);
}
