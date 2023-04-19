package com.akv.example.rest_service_sport.services;


import com.akv.example.rest_service_sport.dao.PlayerRepository;
import com.akv.example.rest_service_sport.dao.TeamRepository;
import com.akv.example.rest_service_sport.entity.Player;
import com.akv.example.rest_service_sport.entity.Team;
import com.akv.example.rest_service_sport.exceptions.NotFoundPlayerException;
import com.akv.example.rest_service_sport.exceptions.NotFoundTeamException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public List<Player> getAllTeamPlayers(Integer teamId) {
        return teamRepository.findById(teamId).orElseThrow(() -> new NotFoundTeamException(teamId)).getPlayers();
    }

    @Override
    public void deletePlayer(int playerId) {
        playerRepository.deleteById(playerId);
    }

    @Override
    public Player savePlayer(Integer teamId, Player player) {
        Team team = teamRepository.findById(teamId).orElseThrow(() -> new NotFoundTeamException(teamId));
        player.setTeam(team);
        return playerRepository.save(player);
    }

    @Override
    public Team playerChangeTeamByPlayerId(Integer playerId, Integer newTeamId) {
        Team team = teamRepository.findById(newTeamId).orElseThrow(() -> new NotFoundTeamException(newTeamId));
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new NotFoundPlayerException(playerId));
        player.setTeam(team);
        return playerRepository.saveAndFlush(player).getTeam();
    }

    @Override
    public List<Player> findAllByPosition(Integer teamId, String position) {
        if(!teamRepository.existsById(teamId)) throw new NotFoundTeamException(teamId);
        return playerRepository.findAllByPosition(teamId, position);
    }
}
