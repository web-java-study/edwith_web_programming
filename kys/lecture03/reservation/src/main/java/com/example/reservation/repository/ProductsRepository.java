package com.example.reservation.repository;

import com.example.reservation.domain.Category;
import com.example.reservation.domain.CategoryDisplay;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ProductsRepository implements CategoryDisplayRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductsRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<CategoryDisplay> allCategoryDisplay() {
        return jdbcTemplate.query("select * from product", productRowMapper());
    }

    @Override
    public List<CategoryDisplay> selectCategory(Integer category_id) {
        return jdbcTemplate.query("select * from product where category_id = ?", productRowMapper(), category_id);

    }

    private RowMapper<CategoryDisplay> productRowMapper() {
        return (rs, rowNum) -> {
            CategoryDisplay products = new CategoryDisplay();
            products.setId(rs.getInt("id"));
            products.setCategory_id(rs.getInt("category_id"));
            products.setDescription(rs.getString("description"));
            products.setContent(rs.getString("content"));
            return products;
        };
    }
}
