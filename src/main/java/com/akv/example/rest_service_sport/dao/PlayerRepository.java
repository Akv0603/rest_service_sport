package com.akv.example.rest_service_sport.dao;


import com.akv.example.rest_service_sport.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    //тут надо запрос сделать на SQL, указав nativeQuery = true: запрос выбирает игрока по id команды и его позиции
    //связываем с параметрами метода
    @Query(nativeQuery = true, value = "select * from players where team_id = :teamId and position = :position ")
    List<Player> findAllByPosition(@Param("teamId") Integer teamId, @Param("position") String position);

}
