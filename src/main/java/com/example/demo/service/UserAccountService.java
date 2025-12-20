package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount save(UserAccount user);
    List<UserAccount> getAllUsers();
    UserAccount findByUsername(String username);  // <-- match your controller
}
