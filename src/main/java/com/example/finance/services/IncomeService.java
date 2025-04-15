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
}
