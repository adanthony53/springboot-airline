package com.example.airline.service;

import com.example.airline.entity.Flight;

public interface FlightService {
    Flight findByFlightNum(Integer flight_num);
}
