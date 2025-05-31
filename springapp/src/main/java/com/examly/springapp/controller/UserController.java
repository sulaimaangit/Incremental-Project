package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entity.User;
import com.examly.springapp.service.UserService;

@RestController
@RequestMapping("/api/user")
// @CrossOrigin( origins = "https://8081-fefbfafaaeabd311579308baedcbcbaefadone.premiumproject.examly.io/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(user));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user){
        user = userService.loginUser(user);
        if(user == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid username and password");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
        }
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }



}
