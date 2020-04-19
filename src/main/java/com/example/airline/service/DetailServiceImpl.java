package com.example.airline.service;

import com.example.airline.entity.DetailQuery;
import com.example.airline.entity.Flight;
import com.example.airline.repository.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private DetailRepository detailRepository;

    @Override
    public Flight query(DetailQuery detailQuery) {
        if (detailQuery.getCarrierID() == null) {
            return detailRepository.getFlightByID(detailQuery.getCarrierID(), detailQuery.getFlightNumber(), detailQuery.getDate());
        } else if (detailQuery.getCarrierName() == null) {
            return detailRepository.getFlightByName(detailQuery.getCarrierName(), detailQuery.getFlightNumber(), detailQuery.getDate());
        } else {
            return detailRepository.getFlightDefault(detailQuery.getCarrierID(), detailQuery.getCarrierName(), detailQuery.getFlightNumber(), detailQuery.getDate());
        }
    }
}
