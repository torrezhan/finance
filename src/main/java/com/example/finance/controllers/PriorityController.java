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

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Priority>> getPriorities(@PathVariable Long userId) {
        return ResponseEntity.ok(priorityService.getPrioritiesByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Priority> createPriority(@RequestBody Priority priority) {
        return ResponseEntity.ok(priorityService.createPriority(priority));
    }
}
