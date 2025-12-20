package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {
    UserAccount findByUsername(String username);

    void save(UserAccount user);

    List<UserAccount> getAllUsers(); // Add this
}
