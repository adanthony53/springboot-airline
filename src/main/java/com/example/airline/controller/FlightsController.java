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

//    @GetMapping("/search")
//    public String searchPage() { return "index"; }

//    @PostMapping("/search")
//    public String search(@RequestParam("originCity") String originCity, @RequestParam("destCity") String destCity,
//                         @RequestParam("date") String date, @RequestParam("travelers") String travelers,
//                         @RequestParam("stops") String stops, Model model) {
//        model.addAttribute("flights", flightService.query1(originCity, destCity, date, travelers, stops));
//        model.addAttribute("originCity", originCity);
//        model.addAttribute("destCity", destCity);
//        return "search";
//    }
//
//    public String search2() {
//
//    }

//    @PostMapping("/searchSort")
//    public String searchSort(@RequestParam("originCity") String originCity, @RequestParam("destCity") String destCity,
//                         @RequestParam("date") Integer date, @RequestParam("sorting") Integer sorting, Model model) {
//        System.out.println(originCity + ", " + destCity+ ", " + date+ ", " + sorting);
//        //model.addAttribute("flights", flightService.query1(originCity, destCity, date, sorting));
//        return "search";
//    }

    @PostMapping("/search")
    public String search(FlightQuery flightQuery, Model model) {
        System.out.println(flightQuery.toString());
        model.addAttribute("flights", flightService.query(flightQuery));
        model.addAttribute("originCity", flightQuery.getOriginCity());
        model.addAttribute("destCity", flightQuery.getDestCity());
        model.addAttribute("date", flightQuery.getDate());
        return "search";
    }

    @PostMapping("/searchUpdate")
    public String searchUpdate(FlightQuery flightQuery, Model model) {
        System.out.println(flightQuery.toString());
        model.addAttribute("flights", flightService.query(flightQuery));
        model.addAttribute("originCity", flightQuery.getOriginCity());
        model.addAttribute("destCity", flightQuery.getDestCity());
        model.addAttribute("date", flightQuery.getDate());
        return "search";
    }
}
