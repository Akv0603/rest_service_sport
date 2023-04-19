package com.akv.example.rest_service_sport.exceptions;

public class NotFoundTeamException extends RuntimeException{
    //исключение, если команда не найдена. по id
    public NotFoundTeamException(Integer id){
        super(String.format("Team %d not found", id));
    }
}
