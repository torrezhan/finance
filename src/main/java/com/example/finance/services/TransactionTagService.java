package com.example.finance.services;

import com.example.finance.models.TransactionTag;
import com.example.finance.repositories.TransactionTagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTagService {

    private final TransactionTagRepository transactionTagRepository;

    public TransactionTagService(TransactionTagRepository transactionTagRepository) {
        this.transactionTagRepository = transactionTagRepository;
    }

    public List<TransactionTag> getAllTransactionTags() {
        return transactionTagRepository.findAll();
    }

    public TransactionTag getTransactionTagById(Long id) {
        return transactionTagRepository.findById(id).orElse(null);
    }

    public TransactionTag createTransactionTag(TransactionTag transactionTag) {
        return transactionTagRepository.save(transactionTag);
    }

    public TransactionTag updateTransactionTag(Long id, TransactionTag updated) {
        return transactionTagRepository.findById(id).map(tag -> {
            tag.setName(updated.getName());
            // Add fields as necessary
            return transactionTagRepository.save(tag);
        }).orElse(null);
    }

    public boolean deleteTransactionTag(Long id) {
        if (transactionTagRepository.existsById(id)) {
            transactionTagRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
// ... existing code ...