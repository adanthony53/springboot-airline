package com.example.airline.service;

import com.example.airline.entity.DetailQuery;
import com.example.airline.entity.Flight;
import com.example.airline.entity.FlightQuery;

import java.util.List;

public interface SearchService {
    Flight findByFlightNum(Integer flight_num);

    List<Flight> query(FlightQuery flightQuery);

    List<String> getCarrierName(List<Flight> query);

    List<Flight> queryDetail(DetailQuery detailQuery);

    Flight findByFid(String id);

    List<Flight> getFlightsByFid(List<Long> fids);
}
