package com.example.reservation.controller;

import com.example.reservation.domain.Category;
import com.example.reservation.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categorys")
    @ResponseBody
    public Category categoryApi() {
        List<Category> categoryList = categoryService.findAllCategory();
        Category categorys = new Category();
        categorys.setName("test");
        System.out.println(categoryList);
        return categorys;
    }
}
