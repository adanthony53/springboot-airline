package com.example.airline.repository;

import com.example.airline.entity.Flight;

public interface DetailRepository {
    Flight getFlightByID(String carrierID, String flightNumber, String date);

    Flight getFlightByName(String carrierName, String flightNumber, String date);

    Flight getFlightDefault(String carrierID, String carrierName, String flightNumber, String date);
}
