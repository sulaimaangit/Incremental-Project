package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.entity.User;


public interface UserService {
    
    public User registerUser(User user);
    public List<User> getAllUser();
    public User loginUser(User user);
}
