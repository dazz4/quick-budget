package com.quickbudget.domain;

import com.quickbudget.service.DBService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BudgetTestSuite {
    @Autowired
    private DBService dbService;

    @Test
    public void testSaveBudget() {
        //Given
        Budget budget = new Budget("Stacking cash");
        Account checking = new Account("Checking", new BigDecimal(1000));
        checking.setBudget(budget);

        Category groceries = new Category("Groceries");
        Category rent = new Category("Rent");
        Category fuel = new Category("Fuel");

        Transaction food = new Transaction(
                "Food",
                LocalDate.now(),
                "Aldi",
                new BigDecimal(50),
                new BigDecimal(0)
        );
        food.setAccount(checking);
        food.setCategory(groceries);

        Transaction theRent = new Transaction(
                "Rent",
                LocalDate.now(),
                "Dariusz",
                new BigDecimal(350),
                new BigDecimal(0)
        );
        theRent.setAccount(checking);
        theRent.setCategory(rent);

        Transaction petrol = new Transaction(
                "Petrol",
                LocalDate.now(),
                "Morrisons",
                new BigDecimal(60),
                new BigDecimal(0)
        );
        petrol.setAccount(checking);
        petrol.setCategory(fuel);

        checking.getTransactions().add(food);
        checking.getTransactions().add(petrol);
        checking.getTransactions().add(theRent);
        budget.getAccounts().add(checking);

        //When
        dbService.saveBudget(budget);
        //Then
        assertNotNull("true", budget);
    }

}