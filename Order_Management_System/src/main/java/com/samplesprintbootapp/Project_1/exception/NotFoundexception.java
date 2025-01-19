package com.samplesprintbootapp.Project_1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundexception extends RuntimeException{

    public NotFoundexception(String message) {
        super(message);
    }
}
