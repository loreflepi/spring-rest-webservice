package com.lore.rest.demorestwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundExceptionHandler(UserNotFoundException userException,
                                                                      WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), userException.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exceptionResponse);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<ExceptionResponse> noContentExceptionHandler(NoContentException userException,
                                                                      WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), userException.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(exceptionResponse);
    }
}
