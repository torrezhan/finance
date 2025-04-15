package com.example.finance.services;

import com.example.finance.models.RecurringTransaction;
import com.example.finance.repositories.RecurringTransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecurringTransactionService {
    private final RecurringTransactionRepository recurringTransactionRepository;

    public RecurringTransactionService(RecurringTransactionRepository recurringTransactionRepository) {
        this.recurringTransactionRepository = recurringTransactionRepository;
    }

    public List<RecurringTransaction> getRecurringTransactionsByUser(Long userId) {
        return recurringTransactionRepository.findByUserId(userId);
    }

    public RecurringTransaction createRecurringTransaction(RecurringTransaction transaction) {
        return recurringTransactionRepository.save(transaction);
    }
}
