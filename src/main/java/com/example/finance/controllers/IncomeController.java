package com.example.finance.controllers;

import com.example.finance.models.Income;
import com.example.finance.services.IncomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Income>> getIncome(@PathVariable Long userId) {
        return ResponseEntity.ok(incomeService.getIncomeByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income) {
        return ResponseEntity.ok(incomeService.createIncome(income));
    }

    // List all Income
    @GetMapping
    public ResponseEntity<List<Income>> getAllIncome() {
        return ResponseEntity.ok(incomeService.getAllIncome());
    }

    // Get single Income by id
    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        Income income = incomeService.getIncomeById(id);
        if (income != null) return ResponseEntity.ok(income);
        return ResponseEntity.notFound().build();
    }

    // Update Income by id
    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        Income updated = incomeService.updateIncome(id, income);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // Delete Income by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        if (incomeService.deleteIncome(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}