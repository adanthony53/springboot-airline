package com.example.airline.controller;

import com.example.airline.entity.DetailQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class DetailController {

    @GetMapping("/detail")
    public String detailPage() {
        return "detail";
    }

    @PostMapping("/detail")
    public String detail(DetailQuery detailQuery, Model model) {
        System.out.println(detailQuery.toString());
        return "detail";
    }
}
