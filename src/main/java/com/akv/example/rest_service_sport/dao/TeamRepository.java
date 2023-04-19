package com.akv.example.rest_service_sport.dao;


import com.akv.example.rest_service_sport.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
