package com.example.SpringBootDev.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        // Handle NotFoundException
        if (exception instanceof NotFoundException) {
            errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        // Handle generic exceptions
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
