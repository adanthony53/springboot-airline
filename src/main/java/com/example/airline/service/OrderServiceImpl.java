package com.example.airline.service;

import com.example.airline.entity.Order;
import com.example.airline.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void orderByIdCount(String id, String count) {
        orderRepository.orderByIdCount(Long.parseLong(id), Long.parseLong(count));
    }

    @Override
    public void saveOrder(String username, String id, String count) {
        Long longId = Long.parseLong(id);
        Long longCount = Long.parseLong(count);
        Order order = new Order(username, longId, longCount);
        orderRepository.saveOrder(order);
    }

    @Override
    public List<Long> getFidsByUsername(String username) {
        return orderRepository.getFidsByUsername(username);
    }
}
