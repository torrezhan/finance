package com.example.finance.services;

import com.example.finance.models.Budget;
import com.example.finance.repositories.BudgetRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BudgetService {
    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public List<Budget> getBudgetsByUser(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }
}
