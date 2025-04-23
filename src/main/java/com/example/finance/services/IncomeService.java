package com.example.finance.services;

import com.example.finance.models.Income;
import com.example.finance.repositories.IncomeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public List<Income> getIncomeByUser(Long userId) {
        return incomeRepository.findByUserId(userId);
    }

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    // List all Incomes
    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    // Get one by id
    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id).orElse(null);
    }

    // Update by id
    public Income updateIncome(Long id, Income updated) {
        return incomeRepository.findById(id).map(income -> {
            income.setAmount(updated.getAmount());
            income.setDescription(updated.getDescription());
            income.setUser(updated.getUser());
            // Add additional fields as needed
            return incomeRepository.save(income);
        }).orElse(null);
    }

    // Delete by id
    public boolean deleteIncome(Long id) {
        if (incomeRepository.existsById(id)) {
            incomeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
