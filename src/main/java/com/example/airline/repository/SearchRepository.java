package com.example.airline.repository;

import com.example.airline.entity.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchRepository {
    Flight findByFlightNum(Integer flight_num);

    List<Flight> queryDefault(@Param("originCity") String originCity, @Param("destCity") String destCity,
                        @Param("day") Integer day, @Param("travelers") Integer travelers);

    List<Flight> queryPriceLowestFirst(String originCity, String destCity, int day, int travelers);

    List<Flight> queryPriceHighestFirst(String originCity, String destCity, int day, int travelers);

    List<Flight> queryDurationLowestFirst(String originCity, String destCity, int day, int travelers);

    List<Flight> queryDurationHighestFirst(String originCity, String destCity, int day, int travelers);

    String getCarrierName(@Param("carrier_id") String carrier_id);

    List<Flight> getFlightByID(@Param("carrierID") String carrierID,
                               @Param("flightNumber") String flightNumber,
                               @Param("date") Integer date);

    Flight findByFid(Long id);


}
