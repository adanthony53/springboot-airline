package com.example.airline.controller;

import com.example.airline.entity.Flight;
import com.example.airline.entity.User;
import com.example.airline.service.OrderService;
import com.example.airline.service.SearchService;
import com.example.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SearchService searchService;

    @GetMapping("/register")
    public String registerPage() { return "register"; }

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping("/order")
    public String orderPage(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        List<Long> fids = orderService.getFidsByUsername(user.getUsername());
        List<Flight> flights = searchService.getFlightsByFid(fids);
        Collections.sort(flights, new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                return o1.getDay_of_month() - o2.getDay_of_month();
            }
        });
        model.addAttribute("flights", flights);
        return "user_order";
    }

    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        userService.register(username, password);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        //System.out.println(username + ", " + password);
        User user = userService.login(username, password);
        if (user == null) { return "login"; } //System.out.println("login failed");
        //System.out.println("login succeed");
        session.setAttribute("user", user);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "index";
    }
}
