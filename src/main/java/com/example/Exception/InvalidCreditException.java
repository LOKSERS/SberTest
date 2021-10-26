package com.example.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class InvalidCreditException extends RuntimeException {
    public InvalidCreditException(String message) {
        super(message);
    }
}
