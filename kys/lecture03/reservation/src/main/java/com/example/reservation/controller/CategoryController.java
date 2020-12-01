package com.example.reservation.controller;

import com.example.reservation.domain.Category;
import com.example.reservation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/categorys", method= RequestMethod.GET)
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Category categoryApi(Model model) {
        List<Category> categoryList = categoryService.findAllCategory();
        Category categorys = new Category();
        categorys.setList(categoryList);
        return categorys;
    }
}
