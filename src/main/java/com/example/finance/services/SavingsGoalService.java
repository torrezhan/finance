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

    // List all SavingsGoals
    public List<SavingsGoal> getAllSavingsGoals() {
        return savingsGoalRepository.findAll();
    }

    // Get one by id
    public SavingsGoal getSavingsGoalById(Long id) {
        return savingsGoalRepository.findById(id).orElse(null);
    }

    // Update SavingsGoal by id
    public SavingsGoal updateSavingsGoal(Long id, SavingsGoal updated) {
        return savingsGoalRepository.findById(id).map(goal -> {
            goal.setName(updated.getName());
            goal.setTargetAmount(updated.getTargetAmount());
            goal.setUser(updated.getUser());
            // Add other fields as necessary
            return savingsGoalRepository.save(goal);
        }).orElse(null);
    }

    // Delete by id
    public boolean deleteSavingsGoal(Long id) {
        if (savingsGoalRepository.existsById(id)) {
            savingsGoalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}