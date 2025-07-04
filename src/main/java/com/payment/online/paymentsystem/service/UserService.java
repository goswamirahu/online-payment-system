package com.payment.online.paymentsystem.service;

import com.payment.online.paymentsystem.entity.User;

public interface UserService {
    User registerUser(User user);
    User login(String email, String password);
    public boolean validateUser(String email, String password);

}
