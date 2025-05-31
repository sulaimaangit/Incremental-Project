package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.entity.Player;
import com.examly.springapp.entity.Team;

@Repository
public interface TeamRepo extends JpaRepository<Team, Long> {
    

    

}
