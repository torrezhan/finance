package com.example.finance.controllers;

import com.example.finance.models.SavingsGoal;
import com.example.finance.services.SavingsGoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/savings-goals")
public class SavingsGoalController {
    private final SavingsGoalService savingsGoalService;

    public SavingsGoalController(SavingsGoalService savingsGoalService) {
        this.savingsGoalService = savingsGoalService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SavingsGoal>> getSavingsGoals(@PathVariable Long userId) {
        return ResponseEntity.ok(savingsGoalService.getSavingsGoalsByUser(userId));
    }

    @PostMapping
    public ResponseEntity<SavingsGoal> createSavingsGoal(@RequestBody SavingsGoal goal) {
        return ResponseEntity.ok(savingsGoalService.createSavingsGoal(goal));
    }

    // List all
    @GetMapping
    public ResponseEntity<List<SavingsGoal>> getAllSavingsGoals() {
        return ResponseEntity.ok(savingsGoalService.getAllSavingsGoals());
    }

    // Get one by id
    @GetMapping("/{id}")
    public ResponseEntity<SavingsGoal> getSavingsGoalById(@PathVariable Long id) {
        SavingsGoal goal = savingsGoalService.getSavingsGoalById(id);
        if (goal != null) return ResponseEntity.ok(goal);
        return ResponseEntity.notFound().build();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<SavingsGoal> updateSavingsGoal(@PathVariable Long id, @RequestBody SavingsGoal goal) {
        SavingsGoal updated = savingsGoalService.updateSavingsGoal(id, goal);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable Long id) {
        if (savingsGoalService.deleteSavingsGoal(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}