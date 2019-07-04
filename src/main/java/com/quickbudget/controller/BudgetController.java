package com.quickbudget.controller;

import com.quickbudget.domain.BudgetDto;
import com.quickbudget.mapper.BudgetMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/budget")
public class BudgetController {
    @Autowired
    private DBService dbService;
    @Autowired
    private BudgetMapper budgetMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getBudgets")
    public List<BudgetDto> getBudgets() {
        return budgetMapper.mapToBudgetDtoList(dbService.getAllBudgets());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getBudget")
    public BudgetDto getBudget(Long budgetId) {
        return new BudgetDto(1L, "Test budget", new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBudget    ")
    public void deleteBudget(Long budgetId) {

    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateBudget")
    public BudgetDto updateBudget(Long budgetId) {
        return new BudgetDto(1L, "Updated budget", new ArrayList<>());
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBudget")
    public void createBudget(BudgetDto budgetDto) {

    }
}
