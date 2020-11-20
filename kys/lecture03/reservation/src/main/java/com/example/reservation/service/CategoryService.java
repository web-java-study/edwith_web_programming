package com.example.reservation.service;

import com.example.reservation.domain.Category;
import com.example.reservation.repository.CategoryRepository;
import com.example.reservation.repository.CategoryTemplateRepository;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryTemplateRepository();

    public List<Category> findAllCategory() {
        return categoryRepository.allCategory();
    }

    public Optional<Category> findOne(String name) {
        return categoryRepository.findName(name);
    }
}
