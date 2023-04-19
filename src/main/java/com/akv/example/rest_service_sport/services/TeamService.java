package com.akv.example.rest_service_sport.services;


import com.akv.example.rest_service_sport.entity.Team;

import java.time.LocalDate;
import java.util.List;

public interface TeamService {
    public List<Team> getAllTeams();

    public List<Team> findAllBySportType(String sportType);

    public List<Team> findAllByCreateDateBetween(LocalDate dateOne, LocalDate dateTwo);

    public void saveTeam(Team team);

    public void deleteTeam(int id);
}
