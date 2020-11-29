package com.example.reservation.controller;

import com.example.reservation.domain.CategoryDisplay;
import com.example.reservation.service.CategoryDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryDisplayController {
    private final CategoryDisplayService categoryDisplayService;

    @Autowired
    public CategoryDisplayController(CategoryDisplayService categoryDisplayService) {
        this.categoryDisplayService = categoryDisplayService;
    }

    @GetMapping("products")
    public CategoryDisplay products(Model model) {
        List<CategoryDisplay> productsList = categoryDisplayService.
    }

}
