package com.example.airline.service;

import com.example.airline.entity.Flight;
import com.example.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight findByFlightNum(Integer flight_num) {
        return flightRepository.findByFlightNum(flight_num);
    }

    @Override
    public List<Flight> query(String originCity, String destCity, String date, String travelers, String tripType, String stops) {
        return null;
    }
}
