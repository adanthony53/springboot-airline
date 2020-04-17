package com.example.airline.service;

import com.example.airline.entity.User;

public interface UserService {
    void register(String username, String password);

    User login(String username, String password);
}
