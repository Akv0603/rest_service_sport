package com.akv.example.rest_service_sport.controllers;

import com.akv.example.rest_service_sport.entity.Team;
import com.akv.example.rest_service_sport.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/sport")
public class TeamController {

    @Autowired
    private TeamService teamService;

//показать все команды
    @GetMapping("/teams")
    public List<Team> showAllTeams(){
        List<Team> allTeams =teamService.getAllTeams();
        return allTeams;
    }

//показать все команды отфильтрованные по виду спорта
    //http://localhost:8080/sport/teams//sport-type?type=Soccer пример вызова
    @GetMapping("/teams/sport-type")
    public List<Team> showAllTeamsBySportType(@RequestParam(name = "type") String sportType){
        return teamService.findAllBySportType(sportType);
    }

//Показать все команды, отфильтрованные в диапазоне дат
//В постмане в params вводим date-one 1900-01-01  date-two 1950-12-12 например и будет вывод команд в этом диапазоне дат
    @GetMapping("/teams/create-dates")
    public List<Team> showAllTeamsByCreationDateBetween(
            @RequestParam(name = "date-one") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOne,
            @RequestParam(name = "date-two") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTwo){
        if(dateTwo.isBefore(dateOne)) throw new DateTimeException("enter date correctly!");
        return teamService.findAllByCreateDateBetween(dateOne, dateTwo);
    }

//Добавить команду
    @PostMapping("/teams")
    public Team addNewTeam(@RequestBody Team team){
        teamService.saveTeam(team);
        return team;
    }

//Изменить данные команды
    @PutMapping("/teams")
    public Team updateTeam(@RequestBody Team team){
        teamService.saveTeam(team);
        return team;
    }

//под нож команду!
    @DeleteMapping("/teams/{id}")
    public String deleteTeam(@PathVariable int id){
        teamService.deleteTeam(id);
        return "team with id " + id + " was deleted!";
    }
}
