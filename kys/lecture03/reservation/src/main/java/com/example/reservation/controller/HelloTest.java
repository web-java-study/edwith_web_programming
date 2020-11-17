package com.example.reservation.controller;

import com.example.reservation.domain.Todos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-api")
    @ResponseBody
    public Todos helloApi(@RequestParam("name") String name) {
        Todos todos = new Todos();
        todos.setName(name);
        return todos;
    }

    @GetMapping("detail")
    public String detail() {
        return "detail";
    }
}
