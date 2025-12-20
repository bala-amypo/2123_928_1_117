package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.LoginEvent;

public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

    List<LoginEvent> findByUserId(Long userId);

    List<LoginEvent> findByUserIdAndStatus(
            Long userId,
            LoginEvent.LoginStatus status
    );
}
