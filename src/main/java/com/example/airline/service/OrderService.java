package com.example.airline.service;

import java.util.List;

public interface OrderService {

    void orderByIdCount(String id, String count);

    void saveOrder(String username, String id, String count);

    List<Long> getFidsByUsername(String username);
}
