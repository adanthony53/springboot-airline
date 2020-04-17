package com.example.airline.controller;

import com.example.airline.entity.Flight;
import com.example.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    private FlightService flightService;

//    @GetMapping("/search")
//    public String searchPage() { return "index"; }

    @PostMapping("/search")
    public String search(@RequestParam("originCity") String originCity, @RequestParam("destCity") String destCity,
                         @RequestParam("date") String date, @RequestParam("travelers") String travelers,
                         @RequestParam("stops") String stops, Model model) {
        System.out.println(originCity + ", " + destCity + ", " + date + ", " + travelers + ", " + stops);
        model.addAttribute("flights", flightService.query1(originCity, destCity, date, travelers, stops));
        return "search";
    }
}
