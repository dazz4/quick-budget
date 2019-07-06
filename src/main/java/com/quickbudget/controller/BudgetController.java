package com.quickbudget.controller;

import com.quickbudget.domain.BudgetDto;
import com.quickbudget.mapper.BudgetMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
    public BudgetDto getBudget(@RequestParam Long budgetId) throws BudgetNotFoundException {
        return budgetMapper.mapToBudgetDto(
                dbService.getBudget(budgetId)
                .orElseThrow(BudgetNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBudget", consumes = APPLICATION_JSON_VALUE)
    public void createBudget(@RequestBody BudgetDto budgetDto) {
        dbService.saveBudget(budgetMapper.mapToBudget(budgetDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateBudget")
    public BudgetDto updateBudget(@RequestBody BudgetDto budgetDto) {
        return budgetMapper.mapToBudgetDto(dbService.saveBudget(budgetMapper.mapToBudget(budgetDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteBudget")
    public void deleteBudget(@RequestParam Long budgetId) {
        dbService.deleteBudget(budgetId);
    }
}
