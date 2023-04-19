package com.akv.example.rest_service_sport.exceptions;

public class NotFoundPlayerException extends RuntimeException{
    //исключение, если игрок не найден. по id
    public NotFoundPlayerException(Integer id){
        super(String.format("Player %d not found", id));
    }
}
