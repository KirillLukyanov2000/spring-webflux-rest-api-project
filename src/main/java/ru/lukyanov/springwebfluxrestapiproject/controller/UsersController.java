package ru.lukyanov.springwebfluxrestapiproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import ru.lukyanov.springwebfluxrestapiproject.entity.User;
import ru.lukyanov.springwebfluxrestapiproject.service.UserService;


@Controller
public class UsersController {
    private final UserService userService;
    private final Flux<User> userList;

    public UsersController(UserService userService) {
        this.userService = userService;
        this.userList = userService.findAll();
    }

    @GetMapping("/users")
    public String main(Model model) {
        model.addAttribute("message", "Users List From DB:");
        model.addAttribute("users", userList);
        return "users";
    }
}