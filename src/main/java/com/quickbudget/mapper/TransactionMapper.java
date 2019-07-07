package com.quickbudget.mapper;

import com.quickbudget.domain.Transaction;
import com.quickbudget.domain.TransactionDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionMapper  {
    public Transaction mapToTransaction(final TransactionDto transactionDto) {
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getName(),
                transactionDto.getDate(),
                transactionDto.getPayee(),
                transactionDto.getInflow(),
                transactionDto.getOutflow(),
                transactionDto.getAccount(),
                transactionDto.getCategories()
        );
    }

    public TransactionDto mapToTransactionDto(final Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getName(),
                transaction.getDate(),
                transaction.getPayee(),
                transaction.getInflow(),
                transaction.getOutflow(),
                transaction.getAccount(),
                transaction.getCategories()
        );
    }

    public List<TransactionDto> mapToTransactionDtoList(final List<Transaction> transactions) {
        return transactions.stream()
                .map(t -> new TransactionDto(
                        t.getId(),
                        t.getName(),
                        t.getDate(),
                        t.getPayee(),
                        t.getInflow(),
                        t.getOutflow(),
                        t.getAccount(),
                        t.getCategories()))
                .collect(Collectors.toList());
    }
}
