package com.smlee.AccountApp.repository;

import com.smlee.AccountApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}