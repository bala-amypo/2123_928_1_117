package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserAccount findByUsername(String username) {
        Optional<UserAccount> user = userAccountRepository.findByUsername(username);
        return user.orElse(null); // Fix Optional conversion
    }

    @Override
    public void save(UserAccount user) {
        userAccountRepository.save(user);
    }

    @Override
    public List<UserAccount> getAllUsers() {
        return userAccountRepository.findAll();
    }
}
