package com.example.finance.controllers;

import com.example.finance.models.Category;
import com.example.finance.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Category>> getCategories(@PathVariable Long userId) {
        return ResponseEntity.ok(categoryService.getCategoriesByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    // List all Categories
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    // Get single Category by id
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) return ResponseEntity.ok(category);
        return ResponseEntity.notFound().build();
    }

    // Update Category by id
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Category updated = categoryService.updateCategory(id, category);
        if (updated != null) return ResponseEntity.ok(updated);
        return ResponseEntity.notFound().build();
    }

    // Delete Category by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (categoryService.deleteCategory(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}