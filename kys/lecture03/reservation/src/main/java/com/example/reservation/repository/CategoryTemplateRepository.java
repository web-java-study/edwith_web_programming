package com.example.reservation.repository;

import com.example.reservation.domain.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class CategoryTemplateRepository implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public  CategoryTemplateRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Category> findName(String name) {
        List<Category> result = jdbcTemplate.query("select * from category where name = ?", categoryRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Category> allCategory() {
        return jdbcTemplate.query("select * from category", categoryRowMapper());
    }

    private RowMapper<Category> categoryRowMapper() {
        return (rs, rowNum) -> {
            Category category = new Category();
            category.setName(rs.getString("name"));
            return category;
        };
    }
}
