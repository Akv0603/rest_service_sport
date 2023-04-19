package com.akv.example.rest_service_sport.controllers;



import com.akv.example.rest_service_sport.entity.Player;
import com.akv.example.rest_service_sport.entity.Team;
import com.akv.example.rest_service_sport.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sport/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

//все игроки в конкретной команде
    @GetMapping("/{teamId}")
    public List<Player> showAllTeamPlayers(@PathVariable Integer teamId){
        List<Player> players = playerService.getAllTeamPlayers(teamId);
        return players;
    }

//Показать игроков конкретной команды, фильтр по позициям
//http://localhost:8080/sport/players/1/positions пример ввода с параметрами
// в постмане - param  position  Defender
    @GetMapping("/{teamId}/positions")
    public List<Player> showPlayersByPositions(@PathVariable Integer teamId, @RequestParam(name = "position") String position){
        return playerService.findAllByPosition(teamId, position);
    }

//Добавим игрока в конкретную команду
    @PostMapping("/{teamId}")
    public Player addNewPlayer(@RequestBody Player player, @PathVariable Integer teamId){
        playerService.savePlayer(teamId, player);
        return player;
    }

//изменения игрока в конкретной команде
    @PutMapping("/{teamId}")
    public Player updatePlayerByTeam(@PathVariable Integer teamId, @RequestBody Player player){
        playerService.savePlayer(teamId, player);
        return player;
    }

//перекинуть игрока из одной тимы в другую по id игрока в id новой тимы
    //http://localhost:8080/sport/players/1?newTeamId=2 пример вызова в постман
    @PatchMapping("/{playerId}")
    public Team changePlayerByTeam(@PathVariable Integer playerId, @RequestParam(name = "newTeamId") Integer newTeamId){
        return playerService.playerChangeTeamByPlayerId(playerId, newTeamId);
    }

//Удалить игрока по id
    @DeleteMapping("/{playerId}")
    public String deletePlayer(@PathVariable int playerId ){
        playerService.deletePlayer(playerId);
        return "Player with id = " + playerId + " was deleted!";
    }

}
