package com.example.reservation.service;

import com.example.reservation.domain.CategoryDisplay;
import com.example.reservation.repository.CategoryDisplayRepository;

import java.util.List;
import java.util.Optional;

public class CategoryDisplayService {
    private final CategoryDisplayRepository categoryDisplayRepository;

    public CategoryDisplayService(CategoryDisplayRepository categoryDisplayRepository) {
        this.categoryDisplayRepository = categoryDisplayRepository;
    }

    public List<CategoryDisplay> allProductsList() {
        return categoryDisplayRepository.allCategoryDisplay();
    }

    public List<CategoryDisplay> selectCategory(Integer category_id) {
        return categoryDisplayRepository.selectCategory(category_id);
    }
}
