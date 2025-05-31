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

import com.examly.springapp.entity.Player;
import com.examly.springapp.service.PlayerService;

@RestController
@RequestMapping("/api/player")
//@CrossOrigin( origins = "https://8081-fefbfafaaeabd311579308baedcbcbaefadone.premiumproject.examly.io/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<?> add_Player(@RequestBody Player player){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.addPlayer(player));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @PutMapping("/{playerId}")
     public ResponseEntity<?> update_Player(@RequestBody Player player, @PathVariable long playerId){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.updatePlayer(player, playerId));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<?> get_All_Players(){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getAllPlayer());
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/{playerId}")
    public ResponseEntity<?> get_Player_ById(@PathVariable long playerId){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.getPlayerById(playerId));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/{playerId}")
    public ResponseEntity<?> delete_Player_ById(@PathVariable long playerId){
        return ResponseEntity.status(HttpStatus.OK).body(playerService.deletePlayerById(playerId));
    }

  

}
