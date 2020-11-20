package com.example.reservation.repository;


import com.example.reservation.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> findName(String name);
    List<Category> allCategory();
}
