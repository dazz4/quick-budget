package com.quickbudget.controller;

import com.quickbudget.domain.Account;
import com.quickbudget.domain.AccountDto;
import com.quickbudget.mapper.AccountMapper;
import com.quickbudget.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/budget/account")
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

    @RequestMapping(method = RequestMethod.POST, value = "createAccount", consumes = APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDto accountDto) {
        dbService.saveAccount(accountMapper.mapToAccount(accountDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateAccount")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto) {
        return accountMapper.mapToAccountDto(
                dbService.saveAccount(accountMapper.mapToAccount(accountDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteAccount")
    public void deleteAccount(Long accountId) {
        dbService.deleteAccount(accountId);
    }
}
