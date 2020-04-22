package com.example.airline.repository;

import com.example.airline.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderRepository {

    void orderByIdCount(@Param("id") Long id, @Param("count") Long count);

    void saveOrder(Order order);

    List<Long> getFidsByUsername(String username);
}
