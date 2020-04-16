package com.example.airline.controller;

import com.example.airline.entity.Flight;
import com.example.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flights")
public class FlightsController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/search")
    public String search(@RequestParam("originCity") String originCity, @RequestParam("destCity") String destCity,
                         @RequestParam("date") String date, @RequestParam("travelers") String travelers,
                         @RequestParam("tripType") String tripType, @RequestParam("stops") String stops) {
        flightService.query(originCity, destCity, date, travelers, tripType, stops);
        return "index";
    }
}
