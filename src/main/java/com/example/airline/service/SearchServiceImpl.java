package com.example.airline.service;

import com.example.airline.entity.DetailQuery;
import com.example.airline.entity.Flight;
import com.example.airline.entity.FlightQuery;
import com.example.airline.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public Flight findByFlightNum(Integer flight_num) {
        return searchRepository.findByFlightNum(flight_num);
    }


    @Override
    public List<Flight> query(FlightQuery flightQuery) {
        int day = Integer.valueOf(flightQuery.getDate().split("-")[1]);
        int sort = Integer.valueOf(flightQuery.getSort());
        int stops = Integer.valueOf(flightQuery.getStops());
        int travelers = Integer.valueOf(flightQuery.getTravelers());
        if (stops == 0) {
            if (sort == 0)
                return searchRepository.queryDefault(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 1)
                return searchRepository.queryPriceLowestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 2)
                return searchRepository.queryPriceHighestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 3)
                return searchRepository.queryDurationLowestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
            if (sort == 4)
                return searchRepository.queryDurationHighestFirst(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
        }
        return searchRepository.queryDefault(flightQuery.getOriginCity(), flightQuery.getDestCity(), day, travelers);
    }

    @Override
    public List<String> getCarrierName(List<Flight> query) {
        List<String> res = new ArrayList<>();
        for (Flight f : query) {
            res.add(searchRepository.getCarrierName(f.getCarrier_id()));
        }
        return res;
    }

    @Override
    public List<Flight> queryDetail(DetailQuery detailQuery) {
        int day = Integer.valueOf(detailQuery.getDate().split("-")[1]);
        return searchRepository.getFlightByID(detailQuery.getCarrierID(), detailQuery.getFlightNumber(), day);
    }

}
