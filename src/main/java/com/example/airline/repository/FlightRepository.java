package com.example.airline.repository;

import com.example.airline.entity.Flight;

public interface FlightRepository {
    Flight findByFlightNum(Integer flight_num);
}
