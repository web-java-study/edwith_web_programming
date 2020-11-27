package com.example.reservation.service;

import com.example.reservation.repository.CategoryDisplayRepository;

public class CategoryDisplayService {
    private final CategoryDisplayRepository categoryDisplayRepository;

    public CategoryDisplayService(CategoryDisplayRepository categoryDisplayRepository) {
        this.categoryDisplayRepository = categoryDisplayRepository;
    }
}
