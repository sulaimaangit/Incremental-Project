package com.examly.springapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.entity.Player;
import com.examly.springapp.service.OrganizerService;

@RestController
@RequestMapping("/api/organizer")
//@CrossOrigin( origins = "https://8081-fefbfafaaeabd311579308baedcbcbaefadone.premiumproject.examly.io/")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class OrganizerController {
    
   @Autowired
   private OrganizerService organizerService;


   @CrossOrigin(origins = "*",allowedHeaders = "*")
   @PostMapping("/assign-player/{teamId}/{playerId}")
   public ResponseEntity<?> addPlayerToTeam(@PathVariable Long teamId, @PathVariable Long playerId){
    return ResponseEntity.status(HttpStatus.CREATED).body(organizerService.assignPlayerToTeam(teamId,playerId));
   }

   @CrossOrigin(origins = "*",allowedHeaders = "*")
   @GetMapping("/sold-players")
   public ResponseEntity<?> getSoldPlayers(){
    List <Player> soldPlayers = organizerService.getSoldPlayers();
    if(soldPlayers.size()==0){
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no sold players.");
        return ResponseEntity.status(HttpStatus.OK).body(soldPlayers);
        
    }
    else{
        return ResponseEntity.status(HttpStatus.OK).body(soldPlayers);
    }
   }


   @CrossOrigin(origins = "*",allowedHeaders = "*")
   @GetMapping("/unsold-players")
   public ResponseEntity<?> getUnSoldPlayers(){
    List <Player> unSoldPlayers = organizerService.getUnSoldPlayers();
    if(unSoldPlayers.size()==0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("All the players are sold.");
    }
    else{
        return ResponseEntity.status(HttpStatus.OK).body(unSoldPlayers);
    }
   }


   @CrossOrigin(origins = "*",allowedHeaders = "*")
   @PutMapping("/release-player/{playerId}") 
   public ResponseEntity<?> releasePlayerById(@PathVariable Long playerId){
     boolean released = organizerService.releasePlayerFromTeam(playerId);
     if(released==false){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player already released!");
     }
     else{
        return ResponseEntity.status(HttpStatus.CREATED).body(released);
     }
   }


   @CrossOrigin(origins = "*",allowedHeaders = "*")
   @GetMapping("/player-list/{teamId}")
   public ResponseEntity<?> getPlayerListByTeamId(@PathVariable Long teamId){
   List<Player> filteredPlayersByTeamId = organizerService.getPlayerListByTeamId(teamId);
//    if(filteredPlayersByTeamId.size()==0){
//      return ResponseEntity.status(NOT_FOUND).body("They are no players in this team!");
//    }
        return ResponseEntity.status(HttpStatus.OK).body(filteredPlayersByTeamId);
   }

   @CrossOrigin(origins = "*",allowedHeaders = "*")
   @GetMapping("/player-list/category/{category}")
   public ResponseEntity<?> getPlayerByCategory(@PathVariable String category){
     return  ResponseEntity.status(HttpStatus.OK).body(organizerService.findPlayersByCategory(category));
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @GetMapping("/team-list")
    public ResponseEntity<?> getAllTeams_(){
        return  ResponseEntity.status(HttpStatus.OK).body(organizerService.getAllTeams());
       }

}

   
