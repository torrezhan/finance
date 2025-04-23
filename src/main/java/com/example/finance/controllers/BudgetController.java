package com.example.finance.controllers;

import com.example.finance.models.Budget;
import com.example.finance.services.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {
    private final BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Budget>> getBudgets(@PathVariable Long userId) {
        return ResponseEntity.ok(budgetService.getBudgetsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        return ResponseEntity.ok(budgetService.createBudget(budget));
    }

    // List all Budgets
    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets() {
        return ResponseEntity.ok(budgetService.getBudgetsByUser(null));
    }

    // Get single Budget by id
    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
        Budget budget = budgetService.getBudgetById(id);
        if (budget != null) return ResponseEntity.ok(budget);
        return ResponseEntity.notFound().build();
    }

    // Update Budget by id
    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Budget updated = budgetService.updateBudget(id, budget);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // Delete Budget by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        if (budgetService.deleteBudget(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
