package com.examly.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.entity.Team;

@RestController
//@CrossOrigin( origins = "https://8081-fefbfafaaeabd311579308baedcbcbaefadone.premiumproject.examly.io/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TestController {
    
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/api/test/welcome")
    public String welcome(){
        return "Welcome to Spring Boot Project.";
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("api/test/team")
    public List<Team> addlist(Team te){
        ArrayList<Team> t=new ArrayList<Team>();
        return t;
    }
}
