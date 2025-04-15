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
}
