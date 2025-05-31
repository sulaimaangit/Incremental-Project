package com.examly.springapp.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.entity.Player;
import com.examly.springapp.repository.PlayerRepo;
import com.examly.springapp.service.PlayerService;


@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public Player addPlayer(Player player) {
        
        player.setSold(false);
       return playerRepo.save(player);
    }

    @Override
    public Player updatePlayer(Player player, long playerId) {
        Player p = playerRepo.findById(playerId).orElse(null);
        if(p==null){
            return null;
        }
        else{
            p.setId(playerId);
            p.setAge(player.getAge());
            p.setBiddingPrice(player.getBiddingPrice());
            p.setCategory(player.getCategory());
            p.setName(player.getName());
            playerRepo.save(p);
            return player;
        }
    }

    @Override
    public List<Player> getAllPlayer() {
       return playerRepo.findAll();
    }

    @Override
    public Player getPlayerById(long playerId) {
        Player p  = playerRepo.findById(playerId).orElse(null);
        return p;


    }

    @Override
    public boolean deletePlayerById(long playerId) {
       Player p = playerRepo.findById(playerId).orElse(null);
       if(p==null){
        return false;
       }
       else{
         playerRepo.deleteById(playerId);
         return true;
       }

    }
    
}
