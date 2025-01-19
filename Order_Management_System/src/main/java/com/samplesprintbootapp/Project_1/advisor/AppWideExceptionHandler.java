package com.samplesprintbootapp.Project_1.advisor;

import com.samplesprintbootapp.Project_1.exception.NotFoundexception;
import com.samplesprintbootapp.Project_1.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NotFoundexception.class)
    public ResponseEntity<StandardResponse> handlerNotFoundexception(NotFoundexception e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, "Not Found", e), HttpStatus.NOT_FOUND
        );
    }

}
