package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.entity.Team;
import com.examly.springapp.service.TeamService;


@RestController
@RequestMapping("/api/team")
// @CrossOrigin( origins = "https://8081-fefbfafaaeabd311579308baedcbcbaefadone.premiumproject.examly.io/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class TeamController {
    
    @Autowired
    private TeamService teamService;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<?> addTeam(@RequestBody Team team){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.addTeam(team));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PutMapping("/{teamId}")
    public ResponseEntity<?> updateTeamById(@PathVariable long teamId, @RequestBody Team team){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.updateTeam(teamId, team));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<?> getAllTeam(){
        return ResponseEntity.status(HttpStatus.OK).body(teamService.getAllTeam());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{teamId}")
    public ResponseEntity<?> getTeamById(@PathVariable long teamId){
        Team t = teamService.getTeamByTeamID(teamId);
        if(t==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team not found");
        }
        else{
            return ResponseEntity.status(HttpStatus.OK).body(t);
        }

    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/{teamId}")
    public ResponseEntity<?> deleteTeamById(@PathVariable long teamId){
       return ResponseEntity.status(HttpStatus.OK).body(teamService.deleteByTeamId(teamId));
    }
}
