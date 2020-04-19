package com.example.airline.controller;

import com.example.airline.entity.Flight;
import com.example.airline.entity.FlightQuery;
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


    @PostMapping("/search")
    public String search(FlightQuery flightQuery, Model model) {
        model.addAttribute("flights", flightService.query(flightQuery));
        model.addAttribute("originCity", flightQuery.getOriginCity());
        model.addAttribute("destCity", flightQuery.getDestCity());
        model.addAttribute("date", flightQuery.getDate());
        return "search";
    }

    @PostMapping("/searchUpdate")
    public String searchUpdate(FlightQuery flightQuery, Model model) {
        model.addAttribute("flights", flightService.query(flightQuery));
        model.addAttribute("originCity", flightQuery.getOriginCity());
        model.addAttribute("destCity", flightQuery.getDestCity());
        model.addAttribute("date", flightQuery.getDate());
        return "search";
    }
}
