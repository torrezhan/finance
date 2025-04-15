package com.example.finance.repositories;

import com.example.finance.models.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {
    List<Priority> findByUserId(Long userId);
}
