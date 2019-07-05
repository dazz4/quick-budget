package com.quickbudget.controller;

import com.quickbudget.domain.Account;
import com.quickbudget.domain.AccountDto;
import com.quickbudget.mapper.AccountMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/budget")
public class AccountController {
    @Autowired
    private DBService dbService;
    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getAccounts")
    public List<AccountDto> getAccounts() {
        return accountMapper.mapToAccountDtoList(dbService.getAllAccounts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getAccount")
    public AccountDto getAccount(@RequestParam Long accountId) throws AccountNotFoundException {
        return accountMapper.mapToAccountDto(
                dbService.getAccount(accountId).orElseThrow(AccountNotFoundException::new));
    }
}
