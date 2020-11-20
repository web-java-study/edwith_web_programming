package com.example.reservation.repository;

import com.example.reservation.domain.Category;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class CategoryTemplateRepository implements CategoryRepository {

    @Override
    public Optional<Category> findName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Category> allCategory() {
        return null;
    }
}
