package com.example.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloTest {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "kang");
        return "hello";
    }

    @GetMapping("param-test")
    public String getParam(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "paramTest";
    }
}
