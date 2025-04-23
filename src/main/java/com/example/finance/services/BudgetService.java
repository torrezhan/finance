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

    // Read one Budget by id
    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }

    // Update Budget by id
    public Budget updateBudget(Long id, Budget updatedBudget) {
        return budgetRepository.findById(id).map(budget -> {
            budget.setAmount(updatedBudget.getAmount());
            budget.setName(updatedBudget.getName());
            budget.setUser(updatedBudget.getUser());
            // add other fields as necessary
            return budgetRepository.save(budget);
        }).orElse(null);
    }

    // Delete Budget by id
    public boolean deleteBudget(Long id) {
        if (budgetRepository.existsById(id)) {
            budgetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
