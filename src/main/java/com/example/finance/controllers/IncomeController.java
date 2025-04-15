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
}
