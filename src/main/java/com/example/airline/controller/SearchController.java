package com.example.airline.controller;

import com.example.airline.entity.FlightQuery;
import com.example.airline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flights")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/search")
    public String search(FlightQuery flightQuery, Model model) {
        model.addAttribute("flights", searchService.query(flightQuery));
        model.addAttribute("originCity", flightQuery.getOriginCity());
        model.addAttribute("destCity", flightQuery.getDestCity());
        model.addAttribute("date", flightQuery.getDate());
        model.addAttribute("carrierNames", searchService.getCarrierName(searchService.query(flightQuery)));
        return "search";
    }


}
