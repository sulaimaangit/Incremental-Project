package com.examly.springapp.service.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.User;
import com.examly.springapp.repository.UserRepo;
import com.examly.springapp.service.UserService;


@Service
public class UserServiceImpl implements UserService{


    

    @Autowired
    UserRepo userRepo;


    @Override
    public User registerUser(User user) {
        user.setPassword(user.getPassword());
        user = userRepo.save(user);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User loginUser(User user) {
        User fetchedUser = userRepo.findByUsername(user.getUsername()).orElse(null);
        return fetchedUser;
    }
    }
    

