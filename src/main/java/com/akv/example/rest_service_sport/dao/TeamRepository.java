package com.akv.example.rest_service_sport.dao;


import com.akv.example.rest_service_sport.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findAllBySportType(String sportType);
    List<Team> findAllByCreateDateBetween(LocalDate dateOne, LocalDate dateTwo);
}
