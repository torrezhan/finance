package com.example.finance.services;

import com.example.finance.models.RecurringTransaction;
import com.example.finance.repositories.RecurringTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RecurringTransactionService {
    List<RecurringTransaction> getAll();
    RecurringTransaction getRecurringTransactionById(Long id);
    RecurringTransaction createRecurringTransaction(RecurringTransaction transaction);
    RecurringTransaction updateRecurringTransaction(Long id, RecurringTransaction transaction);
    boolean deleteRecurringTransaction(Long id);
}

@Service
class RecurringTransactionServiceImpl implements RecurringTransactionService {

    private final RecurringTransactionRepository repository;

    public RecurringTransactionServiceImpl(RecurringTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RecurringTransaction> getAll() {
        return repository.findAll();
    }

    @Override
    public RecurringTransaction getRecurringTransactionById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public RecurringTransaction createRecurringTransaction(RecurringTransaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public RecurringTransaction updateRecurringTransaction(Long id, RecurringTransaction transaction) {
        Optional<RecurringTransaction> existing = repository.findById(id);
        if (existing.isPresent()) {
            RecurringTransaction toUpdate = existing.get();
            toUpdate.setName(transaction.getName());
            toUpdate.setAmount(transaction.getAmount());
            toUpdate.setFrequency(transaction.getFrequency());
            toUpdate.setCategory(transaction.getCategory());
            return repository.save(toUpdate);
        }
        return null;
    }

    @Override
    public boolean deleteRecurringTransaction(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
