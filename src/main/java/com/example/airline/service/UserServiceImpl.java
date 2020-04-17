package com.example.airline.service;

import com.example.airline.entity.User;
import com.example.airline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void register(String username, String password) {
        userRepository.register(new User(UUID.randomUUID().toString(), username, password, 0.0));
    }

    @Override
    public User login(String username, String password) {
        return userRepository.login(username, password);
    }
}
