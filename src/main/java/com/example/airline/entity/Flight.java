package com.example.airline.entity;

import lombok.Data;

@Data
public class Flight {
    private Long fid;
    private Integer month_id;
    private Integer day_of_month;
    private Integer day_of_week;
    private String carrier_id;
    private Integer flight_num;
    private String origin_city;
    private String origin_state;
    private String dest_city;
    private String dest_state;
    private Integer departure_delay;
    private Integer taxi_out;
    private Integer arrival_delay;
    private Integer canceled;
    private Integer actual_time;
    private Integer distance;
    private Integer capacity;
    private Integer price;
}
