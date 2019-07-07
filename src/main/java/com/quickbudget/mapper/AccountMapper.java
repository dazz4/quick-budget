package com.quickbudget.mapper;

import com.quickbudget.domain.Account;
import com.quickbudget.domain.AccountDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public Account mapToAccount(final AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getBalance(),
                accountDto.getBudget(),
                accountDto.getTransactions());
    }

    public AccountDto mapToAccountDto(final Account account) {
        return new AccountDto(
                account.getId(),
                account.getName(),
                account.getBalance(),
                account.getBudget(),
                account.getTransactions());
    }

    public List<AccountDto> mapToAccountDtoList(final List<Account> accounts) {
        return accounts.stream()
                .map(a -> new AccountDto(
                        a.getId(),
                        a.getName(),
                        a.getBalance(),
                        a.getBudget(),
                        a.getTransactions()))
                .collect(Collectors.toList());
    }
}
