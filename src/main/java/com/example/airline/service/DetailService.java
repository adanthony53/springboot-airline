package com.example.airline.service;

import com.example.airline.entity.DetailQuery;
import com.example.airline.entity.Flight;

public interface DetailService {
    Flight query(DetailQuery detailQuery);
}
