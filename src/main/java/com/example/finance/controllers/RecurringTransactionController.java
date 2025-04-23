package com.example.finance.controllers;

// Add necessary imports and annotations, class header, and constructor
import com.example.finance.models.RecurringTransaction;
import com.example.finance.services.RecurringTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recurring-transactions")
public class RecurringTransactionController {
    private final RecurringTransactionService recurringTransactionService;

    public RecurringTransactionController(RecurringTransactionService recurringTransactionService) {
        this.recurringTransactionService = recurringTransactionService;
    }

    // List all recurring transactions
    @GetMapping
    public ResponseEntity<List<RecurringTransaction>> getAll() {
        return ResponseEntity.ok(recurringTransactionService.getAll());
    }

    // Get single recurring transaction by id
    @GetMapping("/{id}")
    public ResponseEntity<RecurringTransaction> getById(@PathVariable Long id) {
        RecurringTransaction rt = recurringTransactionService.getRecurringTransactionById(id);
        if (rt != null) return ResponseEntity.ok(rt);
        return ResponseEntity.notFound().build();
    }

    // Create
    @PostMapping
    public ResponseEntity<RecurringTransaction> create(@RequestBody RecurringTransaction transaction) {
        return ResponseEntity.ok(recurringTransactionService.createRecurringTransaction(transaction));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<RecurringTransaction> update(@PathVariable Long id, @RequestBody RecurringTransaction transaction) {
        RecurringTransaction updated = recurringTransactionService.updateRecurringTransaction(id, transaction);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (recurringTransactionService.deleteRecurringTransaction(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}