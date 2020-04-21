package com.example.airline.controller;

import com.example.airline.entity.DetailQuery;
import com.example.airline.entity.Flight;
import com.example.airline.entity.FlightQuery;
import com.example.airline.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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
        model.addAttribute("count", flightQuery.getTravelers());
        return "search";
    }

    @GetMapping("/order/{id}/{count}")
    public String order(@PathVariable("id") String id,
                        @PathVariable("count") String count,
                        Model model) {
        Flight f = searchService.findByFid(id);
        model.addAttribute("flight", f);
        model.addAttribute("count", count);
        return "order";
    }

    @GetMapping("/confirm/{id}/{count}")
    public String confirm(@PathVariable("id") String id, @PathVariable("count") String count) {
        System.out.println("flight id: " + id + " - count: " + count);
        searchService.orderByIdCount(id, count);
        return "index";
    }

    @GetMapping("/detail")
    public String detailPage() {
        return "detail";
    }

    @PostMapping("/detail")
    public String detail(DetailQuery detailQuery, Model model) {
        System.out.println(detailQuery.toString());
        List<Flight> list = searchService.queryDetail(detailQuery);
        model.addAttribute("flights", searchService.queryDetail(detailQuery));
        model.addAttribute("carrierNames", searchService.getCarrierName(searchService.queryDetail(detailQuery)));
        return "detailList";
    }


}
