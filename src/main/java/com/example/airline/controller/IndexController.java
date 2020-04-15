package com.example.airline.controller;

import com.example.airline.entity.Flight;
import com.example.airline.service.FlightService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private FlightService flightService;

    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/findByFlightNum/{flight_num}")
    public Flight findByFlightNum(@PathVariable("flight_num") Integer flight_num) {
        return flightService.findByFlightNum(flight_num);
    }
}
