package com.examly.springapp.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.examly.springapp.entity.Player;
import com.examly.springapp.entity.Team;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long>{


    @Query("select p from Player p where p.sold = ?1")
    List<Player>findBySold(boolean isSold);

    @Query("select p from Player p where p.category= ?1")
    List<Player>findByCategory(String category);

    List<Player>findByTeam(Team team);

    
    
}
