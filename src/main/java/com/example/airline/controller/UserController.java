package com.example.airline.controller;

import com.example.airline.entity.User;
import com.example.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage() { return "register"; }

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        userService.register(username, password);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        System.out.println(username + ", " + password);
        User user = userService.login(username, password);
        if (user == null) {
            System.out.println("login failed");
        } else {
            System.out.println("login succeed");
        }
        return "index";
    }
}
