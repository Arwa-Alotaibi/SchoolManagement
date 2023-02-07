package com.example.schoolmanagement.Exception;


public class ApiException extends RuntimeException {
    public ApiException(String message){
        super(message);
    }
}