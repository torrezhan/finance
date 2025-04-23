package com.example.finance.services;

import com.example.finance.models.Transaction;
import com.example.finance.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactionsByUser(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Get one by id
    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    // Update by id
    public Transaction updateTransaction(Long id, Transaction updated) {
        return transactionRepository.findById(id).map(transaction -> {
            transaction.setAmount(updated.getAmount());
            transaction.setDescription(updated.getDescription());
            transaction.setDate(updated.getDate());
            transaction.setUser(updated.getUser());
            // Add other fields as necessary
            return transactionRepository.save(transaction);
        }).orElse(null);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}