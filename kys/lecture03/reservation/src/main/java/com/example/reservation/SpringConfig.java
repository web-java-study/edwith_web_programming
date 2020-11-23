package com.example.reservation;

import com.example.reservation.repository.CategoryRepository;
import com.example.reservation.repository.CategoryTemplateRepository;
import com.example.reservation.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;

    public  SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public CategoryService categoryService() {
        return new CategoryService(categoryRepository());
    }

    @Bean
    public CategoryRepository categoryRepository() {
        return new CategoryTemplateRepository(dataSource);
    }
}
