package com.example.demoAnno.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println(this.getClass().getName());
        return "index";
    }

    @PostMapping("/sendForm")
    public String sendForm(String name, String address) {
        System.out.println("name: " + name);
        System.out.println("address: " + address);
        return "redirect:/";
    }
}
