package com.example.airline.controller;

import com.example.airline.entity.Flight;
import com.example.airline.service.OrderService;
import com.example.airline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class OrderController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{id}/{count}")
    public String order(@PathVariable("id") String id,
                        @PathVariable("count") String count,
                        Model model) {
        Flight f = searchService.findByFid(id);
        model.addAttribute("flight", f);
        model.addAttribute("count", count);
        return "order";
    }

    @GetMapping("/confirm/{username}/{id}/{count}")
    public String confirm(@PathVariable("username") String username,
                          @PathVariable("id") String id,
                          @PathVariable("count") String count) {
        orderService.saveOrder(username, id, count);
        orderService.orderByIdCount(id, count);
        return "index";
    }

}
