package com.andrew.demoSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//        import org.springframework.web.bind.annotation.RequestParam;
//    <title>Getting Started: Serving Web Content</title>

@Controller
public class MainController {

    @GetMapping("/")  // главный адрес сайта
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        //model.addAttribute("name", "Andrew");
        return "home";
    }

}

