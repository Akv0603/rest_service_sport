package com.akv.example.rest_service_sport.services;

import com.akv.example.rest_service_sport.dao.TeamRepository;
import com.akv.example.rest_service_sport.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> findAllBySportType(String sportType) {
        return teamRepository.findAllBySportType(sportType);
    }

    @Override
    public List<Team> findAllByCreateDateBetween(LocalDate dateOne, LocalDate dateTwo) {
        return teamRepository.findAllByCreateDateBetween(dateOne, dateTwo);
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
