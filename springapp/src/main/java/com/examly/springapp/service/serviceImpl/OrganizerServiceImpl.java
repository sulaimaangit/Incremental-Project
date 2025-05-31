package com.examly.springapp.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Player;
import com.examly.springapp.entity.Team;
import com.examly.springapp.repository.PlayerRepo;
import com.examly.springapp.repository.TeamRepo;
import com.examly.springapp.service.OrganizerService;
import com.examly.springapp.service.TeamService;


@Service
public class OrganizerServiceImpl implements OrganizerService{

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private TeamRepo teamRepo;

    @Autowired
    private TeamService teamService;
    
    @Override
    public List<Player> getSoldPlayers() {
        return playerRepo.findBySold(true);
    }

    @Override
    public List<Player> getUnSoldPlayers() {
        return playerRepo.findBySold(false);
    }

    @Override
    public boolean assignPlayerToTeam(Long teamId,Long playerId) {
        
       Team team = teamRepo.findById(teamId).orElse(null);
       Player player = playerRepo.findById(playerId).orElse(null);

       if(team==null || player==null){
        return false;
       }
       else{
        player.setTeam(team);
        player.setSold(true);
        player=playerRepo.save(player);
        team.getPlayers().add(player);
        teamRepo.save(team);
        return true;
       }
    }

    @Override
    public boolean releasePlayerFromTeam(Long playerId) {

        Player player = playerRepo.findById(playerId).orElse(null);

        if(player==null){
            return false; //Player not found
        }
        else{
           Team team = teamRepo.findById(player.getTeam().getId()).orElse(null);
           if(team!=null){
            List<Player> playerList = team.getPlayers();
            for(int i=0;i<playerList.size();i++){
                if(playerList.get(i).getId()==playerId){
                    playerList.remove(i);
                    break;
                }
            }
            teamRepo.save(team);
            player.setTeam(null);
            player.setSold(false);
            playerRepo.save(player);
             //playerRepo.deleteById(playerId);
            return true;
           }
           else{
            return false; //but this never happens
           }
        }
    }

    @Override
    public List<Player> getPlayerListByTeamId(Long teamId) {
        System.out.println("Check 1 ------------------ "+teamId);

       //Team team = teamRepo.findById(teamId).orElse(null);
       
        //List<Player> playersWithTeamId=null;
        //if(team!=null)  playersWithTeamId=team.getPlayers();
        //return playersWithTeamId;
        Team tmp = new Team();
        tmp.setId(teamId);
        return playerRepo.findByTeam(tmp);

    }

    @Override
    public List<Player> findPlayersByCategory(String category) {
        return playerRepo.findByCategory(category);
    }

    @Override
    public List<Team> getAllTeams() {
       return teamService.getAllTeam();
    }

   

    
  
   
}
