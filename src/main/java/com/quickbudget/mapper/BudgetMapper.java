package com.quickbudget.mapper;

import com.quickbudget.domain.Budget;
import com.quickbudget.domain.BudgetDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BudgetMapper {
    public Budget mapToBudget(final BudgetDto budgetDto) {
        return new Budget(budgetDto.getId(), budgetDto.getName(), budgetDto.getAccounts());
    }

    public BudgetDto mapToBudgetDto(final Budget budget) {
        return new BudgetDto(budget.getId(), budget.getName(), budget.getAccounts());
    }

    public List<BudgetDto> mapToBudgetDtoList(final List<Budget> budgets) {
        return budgets.stream()
                .map(b -> new BudgetDto(b.getId(), b.getName(), b.getAccounts()))
                .collect(Collectors.toList());
    }
}
