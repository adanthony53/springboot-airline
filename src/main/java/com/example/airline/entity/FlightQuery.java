package com.example.airline.entity;

import lombok.Data;

@Data
public class FlightQuery {

    private String originCity;
    private String destCity;
    private String date;

    // 1: price lowest first
    // 2: price highest first
    // 3: duration lowest first
    // 4: duration highest first
    private String sort;
    private String stops;
    private String travelers;
}
