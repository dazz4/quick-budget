package com.quickbudget.controller;

import com.quickbudget.domain.BudgetDto;
import com.quickbudget.domain.Transaction;
import com.quickbudget.domain.TransactionDto;
import com.quickbudget.mapper.TransactionMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/budget/account/transaction")
public class TransactionController {
    @Autowired
    private DBService dbService;
    @Autowired
    private TransactionMapper transactionMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTransactions")
    public List<TransactionDto> getTransactions() {
        return transactionMapper.mapToTransactionDtoList(dbService.getAllTransactions());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTransaction")
    public TransactionDto getTransaction(@RequestParam Long transactionId) throws TransactionNotFoundException {
        return transactionMapper.mapToTransactionDto(
                dbService.getTransaction(transactionId)
                        .orElseThrow(TransactionNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTransaction", consumes = APPLICATION_JSON_VALUE)
    public void createBudget(@RequestBody TransactionDto transactionDto) {
        dbService.saveTransaction(transactionMapper.mapToTransaction(transactionDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTransaction")
    public TransactionDto updateBudget(@RequestBody TransactionDto transactionDto) {
        return transactionMapper.mapToTransactionDto(
                dbService.saveTransaction(transactionMapper.mapToTransaction(transactionDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTransaction")
    public void deleteTransaction(@RequestParam Long transactionId) {
        dbService.deleteTransaction(transactionId);
    }
}
