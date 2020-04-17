package com.example.airline.repository;

import com.example.airline.entity.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlightRepository {
    Flight findByFlightNum(Integer flight_num);

    List<Flight> query1(@Param("originCity") String originCity, @Param("destCity") String destCity, @Param("day") Integer day);
}
