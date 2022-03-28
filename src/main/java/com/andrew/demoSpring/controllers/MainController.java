package com.andrew.demoSpring.controllers;

import com.andrew.demoSpring.models.DemoUser;
import com.andrew.demoSpring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//        import org.springframework.web.bind.annotation.RequestParam;
//    <title>Getting Started: Serving Web Content</title>

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")  // главный адрес сайта
    public String homePage(Model model) {
        System.out.println("home Page");
        model.addAttribute("title", "Главная страница");
        //model.addAttribute("name", "Andrew");
        return "home";
    }

    @GetMapping("/users")  // Отображение списка пользователей
    public String usersPage(Model model) {
        System.out.println("Users Page");
        Iterable<DemoUser> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user/add")  // Страница для добавления пользователя
    public String userAddGet(Model model) {
        System.out.println("GET user-add");
        model.addAttribute("title", "Главная страница");
        return "user-add";
    }

    @PostMapping("user/add") // Добавление Пользователя
    public String userAddPost(@RequestParam String fio, String age, String comment) {
        System.out.println("POST user-add");
        DemoUser user = new DemoUser(fio, 22, comment);
        //DemoUser user = new DemoUser("MyFIO", 33, "comment");
        System.out.println("age = " + age);
        userRepository.save(user);
        System.out.println("save = ");
        return "home";
    }

}

