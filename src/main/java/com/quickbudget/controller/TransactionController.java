package com.quickbudget.controller;

import com.quickbudget.domain.TransactionDto;
import com.quickbudget.mapper.TransactionMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
