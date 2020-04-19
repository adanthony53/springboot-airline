package com.example.airline.service;

import com.example.airline.entity.Flight;
import com.example.airline.entity.FlightQuery;
import com.example.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Flight> query(FlightQuery flightQuery) {
        int day = Integer.valueOf(flightQuery.getDate().split("-")[1]);
        int sort = Integer.valueOf(flightQuery.getSort());
        int stops = Integer.valueOf(flightQuery.getStops());
        int travelers = Integer.valueOf(flightQuery.getTravelers());
        if (stops == 0) {
            if (sort == 0)
                return flightRepository.queryDefault(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 1)
                return flightRepository.queryPriceLowestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 2)
                return flightRepository.queryPriceHighestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 3)
                return flightRepository.queryDurationLowestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 4)
                return flightRepository.queryDurationHighestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
        }
        return flightRepository.queryDefault(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
    }

    @Override
    public List<String> getCarrierName(List<Flight> query) {
        List<String> res = new ArrayList<>();
        for (Flight f : query) {
            res.add(flightRepository.getCarrierName(f.getCarrier_id()));
        }
        return res;
    }

}
