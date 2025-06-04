package com.smlee.AccountApp.controller;

import com.smlee.AccountApp.entity.Category;
import com.smlee.AccountApp.repository.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository _categoryRepository) {
        this.categoryRepository = _categoryRepository;
    }

    @PostMapping
    public Category createCategory(@RequestBody Category _category) {
        return categoryRepository.save(_category);
    }

    @GetMapping
    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }
}
