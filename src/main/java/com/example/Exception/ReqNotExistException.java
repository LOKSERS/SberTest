package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ReqNotExistException extends RuntimeException{
    public ReqNotExistException(String message) {
        super(message);
    }
}
