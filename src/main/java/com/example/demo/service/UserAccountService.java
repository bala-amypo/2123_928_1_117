package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {

    // Save a user
    UserAccount save(UserAccount user);

    // Get all users
    List<UserAccount> getAllUsers();

    // Get a user by username
    UserAccount getUserByUsername(String username);
}
