package com.example.reservation;

import com.example.reservation.repository.CategoryRepository;
import com.example.reservation.repository.CategoryTemplateRepository;
import com.example.reservation.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public CategoryService categoryService() {
        return new CategoryService(categoryRepository());
    }

    @Bean
    public CategoryRepository categoryRepository() {
        return new CategoryTemplateRepository();
    }
}
