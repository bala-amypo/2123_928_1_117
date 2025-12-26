package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class UserAccountServiceImpl implements UserAccountService {

    private final UserAccountRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserAccountServiceImpl(UserAccountRepository repository,
                                  PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Register new user
     */
    @Override
    public UserAccount register(UserAccount user) {

        // ===== VALIDATIONS =====
        if (user.getUsername() == null || user.getUsername().isBlank()) {
            throw new BadRequestException("Username is required");
        }

        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new BadRequestException("Password is required");
        }

        if (repository.existsByUsername(user.getUsername())) {
            throw new BadRequestException("Username already exists");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        // ===== BUSINESS LOGIC =====
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus("ACTIVE");
        user.setCreatedAt(LocalDateTime.now());

        return repository.save(user);
    }

    /**
     * Get user by ID
     */
    @Override
    public UserAccount getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id " + id));
    }

    /**
     * Get user by username
     */
    @Override
    public UserAccount getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with username " + username));
    }

    /**
     * Get all users
     */
    @Override
    public List<UserAccount> getAllUsers() {
        return repository.findAll();
    }

    /**
     * Disable user
     */
    @Override
    public UserAccount deactivateUser(Long id) {
        UserAccount user = getById(id);
        user.setStatus("INACTIVE");
        return repository.save(user);
    }
}
