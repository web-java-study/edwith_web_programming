package com.example.reservation.repository;

import com.example.reservation.domain.CategoryDisplay;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ProductsRepository implements CategoryDisplayRepository {

    private final JdbcTemplate jdbcTemplate;

    public ProductsRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
    }

    @Override
    public List<CategoryDisplay> allProducts() {
        return jdbcTemplate.query("select * from product");
    }

    private RowMapper<CategoryDisplay> productRowMapper() {
        return (rs, rowNum) -> {
            CategoryDisplay products = new CategoryDisplay();
            products.set
            return products;
        }
    }
}
