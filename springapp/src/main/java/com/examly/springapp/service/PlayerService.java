package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.entity.Player;

public interface PlayerService {
    
    //CRUD
    public Player addPlayer(Player player);
    public Player updatePlayer(Player player, long playerId);
    public List<Player> getAllPlayer();
    public Player getPlayerById(long playerId);
    public boolean deletePlayerById(long playerId);


}
