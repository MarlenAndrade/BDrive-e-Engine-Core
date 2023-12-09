package com.bdrive.examen.UTILS;

public class DataNotExistingException extends Exception{
    public DataNotExistingException(String errorMessage){
        super(errorMessage);
    }
}
