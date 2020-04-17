package com.example.airline.repository;

import com.example.airline.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserRepository {
    void register(User user);

    User login(@Param("username") String username, @Param("password") String password);
}
