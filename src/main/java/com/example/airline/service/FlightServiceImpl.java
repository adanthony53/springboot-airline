package com.example.airline.service;

import com.example.airline.entity.Flight;
import com.example.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight findByFlightNum(Integer flight_num) {
        return flightRepository.findByFlightNum(flight_num);
    }
}
