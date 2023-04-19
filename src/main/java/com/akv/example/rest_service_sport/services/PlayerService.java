package com.akv.example.rest_service_sport.services;



import com.akv.example.rest_service_sport.entity.Player;
import com.akv.example.rest_service_sport.entity.Team;

import java.util.List;

public interface PlayerService {
    public List<Player> getAllTeamPlayers(Integer teamId);

    public void deletePlayer(int playerId);

    public Player savePlayer(Integer teamId, Player player);

    public Team playerChangeTeamByPlayerId(Integer playerId, Integer newTeamId);

    List<Player> findAllByPosition(Integer teamId, String position);

}
