package com.examly.springapp.service;
import java.util.List;
import com.examly.springapp.entity.Player;
import com.examly.springapp.entity.Team;

public interface OrganizerService{
    
     public List<Player> getSoldPlayers();
     public List<Player> getUnSoldPlayers();
     public boolean assignPlayerToTeam(Long teamId,Long PlayerId);
     public boolean releasePlayerFromTeam(Long playerId);
     public List<Player> getPlayerListByTeamId(Long teamId);
     public List<Player> findPlayersByCategory(String category);
     public List<Team> getAllTeams();



  
  
  
    

}
