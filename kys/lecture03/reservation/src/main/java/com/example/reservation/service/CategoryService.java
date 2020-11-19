package com.example.reservation.service;

import com.example.reservation.repository.CategoryRepository;
import com.example.reservation.repository.CategoryTemplateRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository = new CategoryTemplateRepository();
}
