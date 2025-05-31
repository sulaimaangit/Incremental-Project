package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.entity.Team;

public interface TeamService {

    public Team addTeam(Team team);
    public Team updateTeam(long id, Team team);
    public List<Team> getAllTeam();
    public Team getTeamByTeamID(long teamId);
    public boolean deleteByTeamId(long teamId);
}
