package com.example.finance.services;

import com.example.finance.models.Priority;
import com.example.finance.repositories.PriorityRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriorityService {
    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<Priority> getPrioritiesByUser(Long userId) {
        return priorityRepository.findByUserId(userId);
    }

    public Priority createPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    // List all Priorities
    public List<Priority> getAllPriorities() {
        return priorityRepository.findAll();
    }

    // Get single Priority by id
    public Priority getPriorityById(Long id) {
        return priorityRepository.findById(id).orElse(null);
    }

    // Update Priority by id
    public Priority updatePriority(Long id, Priority updated) {
        return priorityRepository.findById(id).map(priority -> {
            priority.setName(updated.getName());
            priority.setUser(updated.getUser());
            // Add other fields as necessary
            return priorityRepository.save(priority);
        }).orElse(null);
    }

    // Delete Priority by id
    public boolean deletePriority(Long id) {
        if (priorityRepository.existsById(id)) {
            priorityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}