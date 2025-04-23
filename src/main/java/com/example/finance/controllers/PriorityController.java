package com.example.finance.controllers;

import com.example.finance.models.Priority;
import com.example.finance.services.PriorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {
    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    // List all Priorities
    @GetMapping
    public ResponseEntity<List<Priority>> getAllPriorities() {
        return ResponseEntity.ok(priorityService.getAllPriorities());
    }

    // Get single Priority by id
    @GetMapping("/{id}")
    public ResponseEntity<Priority> getPriorityById(@PathVariable Long id) {
        Priority priority = priorityService.getPriorityById(id);
        if (priority != null) return ResponseEntity.ok(priority);
        return ResponseEntity.notFound().build();
    }

    // Update Priority by id
    @PutMapping("/{id}")
    public ResponseEntity<Priority> updatePriority(@PathVariable Long id, @RequestBody Priority priority) {
        Priority updated = priorityService.updatePriority(id, priority);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // Delete Priority by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriority(@PathVariable Long id) {
        if (priorityService.deletePriority(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Priority>> getPriorities(@PathVariable Long userId) {
        return ResponseEntity.ok(priorityService.getPrioritiesByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Priority> createPriority(@RequestBody Priority priority) {
        return ResponseEntity.ok(priorityService.createPriority(priority));
    }
}
