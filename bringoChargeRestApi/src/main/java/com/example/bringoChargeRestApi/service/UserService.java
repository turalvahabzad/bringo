package com.example.bringoChargeRestApi.service;

import com.example.bringoChargeRestApi.dto.UserDto;
import com.example.bringoChargeRestApi.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}