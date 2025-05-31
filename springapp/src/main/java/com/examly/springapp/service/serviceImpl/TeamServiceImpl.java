package com.examly.springapp.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Team;
import com.examly.springapp.repository.TeamRepo;
import com.examly.springapp.service.TeamService;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepo teamRepo;
    
    @Override
    public Team addTeam(Team team) {
      
        return teamRepo.save(team);

    }

    @Override
    public Team updateTeam(long id, Team team) {
        team.setId(id);
        Optional<Team> optional=teamRepo.findById(id);
        if(optional.isPresent()){
            return teamRepo.save(team);
        }
        return null;
    }

    @Override
    public List<Team> getAllTeam() {
      return teamRepo.findAll();
    }

    @Override
    public Team getTeamByTeamID(long teamId) {
        return teamRepo.findById(teamId).orElse(null);
    }

    @Override
    public boolean deleteByTeamId(long teamId) {
      Team t = teamRepo.findById(teamId).orElse(null);
      if(t==null){
        return false;
      }
      else{
        teamRepo.deleteById(teamId);
        return true;
      }
       
    }
    

    
    
}
