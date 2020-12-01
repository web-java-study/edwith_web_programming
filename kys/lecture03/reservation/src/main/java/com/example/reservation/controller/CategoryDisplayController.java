package com.example.reservation.controller;

import com.example.reservation.domain.CategoryDisplay;
import com.example.reservation.service.CategoryDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/products", method= RequestMethod.GET)
public class CategoryDisplayController {
    private final CategoryDisplayService categoryDisplayService;

    @Autowired
    public CategoryDisplayController(CategoryDisplayService categoryDisplayService) {
        this.categoryDisplayService = categoryDisplayService;
    }

    @GetMapping
    public CategoryDisplay products(@RequestParam(required = false) Integer categoryId) {
        List<CategoryDisplay> productsList = categoryDisplayService.allProductsList();
        List<CategoryDisplay> selectList = categoryDisplayService.selectCategory(categoryId);
        CategoryDisplay categoryDisplay = new CategoryDisplay();
//        categoryDisplay.setCategory_id(selectList);
        categoryDisplay.setList(selectList);
        return categoryDisplay;
    }
}
