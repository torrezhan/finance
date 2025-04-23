package com.example.finance.services;

import com.example.finance.models.Category;
import com.example.finance.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoriesByUser(Long userId) {
        return categoryRepository.findByUserId(userId);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // List all Categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Read one Category by id
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Update Category by id
    public Category updateCategory(Long id, Category updatedCategory) {
        return categoryRepository.findById(id).map(category -> {
            category.setName(updatedCategory.getName());
            category.setUser(updatedCategory.getUser());
            // Add other fields as necessary
            return categoryRepository.save(category);
        }).orElse(null);
    }

    // Delete Category by id
    public boolean deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}