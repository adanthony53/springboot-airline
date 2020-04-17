package com.example.airline.service;

import com.example.airline.entity.Flight;

import java.util.List;

public interface FlightService {
    Flight findByFlightNum(Integer flight_num);

    List<Flight> query1(String originCity, String destCity, String date, String travelers, String stops);
}
