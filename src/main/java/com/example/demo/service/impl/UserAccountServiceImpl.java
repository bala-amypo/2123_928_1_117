package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userRepository;

    // Save user
    @Override
    public UserAccount save(UserAccount user) {
        return userRepository.save(user);
    }

    // Get all users
    @Override
    public List<UserAccount> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by username
    @Override
    public UserAccount getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}
