package com.example.demo.repository;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.LoginEvent.LoginStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginEventRepository extends JpaRepository<LoginEvent, Long> {

    List<LoginEvent> findByUserid(Long userid);

    List<LoginEvent> findByUseridAndLoginStatus(Long userid, LoginStatus status);

}