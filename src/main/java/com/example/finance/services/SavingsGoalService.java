package com.example.finance.services;

import com.example.finance.models.SavingsGoal;
import com.example.finance.repositories.SavingsGoalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SavingsGoalService {
    private final SavingsGoalRepository savingsGoalRepository;

    public SavingsGoalService(SavingsGoalRepository savingsGoalRepository) {
        this.savingsGoalRepository = savingsGoalRepository;
    }

    public List<SavingsGoal> getSavingsGoalsByUser(Long userId) {
        return savingsGoalRepository.findByUserId(userId);
    }

    public SavingsGoal createSavingsGoal(SavingsGoal goal) {
        return savingsGoalRepository.save(goal);
    }
}
