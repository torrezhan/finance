package com.example.finance.controllers;

import com.example.finance.models.TransactionTag;
import com.example.finance.services.TransactionTagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction-tags")
public class TransactionTagController {

    private final TransactionTagService transactionTagService;

    public TransactionTagController(TransactionTagService transactionTagService) {
        this.transactionTagService = transactionTagService;
    }

    @GetMapping
    public ResponseEntity<List<TransactionTag>> getAllTransactionTags() {
        return ResponseEntity.ok(transactionTagService.getAllTransactionTags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionTag> getTransactionTagById(@PathVariable Long id) {
        TransactionTag tag = transactionTagService.getTransactionTagById(id);
        if (tag != null) return ResponseEntity.ok(tag);
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TransactionTag> createTransactionTag(@RequestBody TransactionTag transactionTag) {
        return ResponseEntity.ok(transactionTagService.createTransactionTag(transactionTag));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionTag> updateTransactionTag(@PathVariable Long id, @RequestBody TransactionTag transactionTag) {
        TransactionTag updated = transactionTagService.updateTransactionTag(id, transactionTag);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransactionTag(@PathVariable Long id) {
        if (transactionTagService.deleteTransactionTag(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}