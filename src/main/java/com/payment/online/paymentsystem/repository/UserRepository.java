package com.payment.online.paymentsystem.repository;

import com.payment.online.paymentsystem.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);  // For login purpose
}

