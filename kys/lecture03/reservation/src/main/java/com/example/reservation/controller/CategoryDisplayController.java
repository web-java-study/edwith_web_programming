package com.example.reservation.controller;

import com.example.reservation.domain.CategoryDisplay;
import com.example.reservation.service.CategoryDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api", method= RequestMethod.GET)
public class CategoryDisplayController {
    private final CategoryDisplayService categoryDisplayService;

    @Autowired
    public CategoryDisplayController(CategoryDisplayService categoryDisplayService) {
        this.categoryDisplayService = categoryDisplayService;
    }

    @RequestMapping(value="/products", method= RequestMethod.GET)
    public CategoryDisplay products(Model model) {
        List<CategoryDisplay> productsList = categoryDisplayService.allProductsList();
        CategoryDisplay categoryDisplay = new CategoryDisplay();
        categoryDisplay.setList(productsList);
        return categoryDisplay;
    }

}
