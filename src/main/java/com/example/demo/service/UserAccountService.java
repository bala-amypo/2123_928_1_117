package com.example.demo.service;

import com.example.demo.entity.UserAccount;

public interface UserAccountService {
    UserAccount findByUsername(String username);

    void save(UserAccount user);  // Important: add this method
}
