package com.akv.example.rest_service_sport.dao;


import com.akv.example.rest_service_sport.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
