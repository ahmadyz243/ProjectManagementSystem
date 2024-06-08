package com.yazdi.projectManagementSystem.exception.handler;

import com.yazdi.projectManagementSystem.exception.EntityNotFoundException;
import com.yazdi.projectManagementSystem.exception.InvalidInputException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleEntityNotFoundException(EntityNotFoundException e){
        log.error("EntityNotFoundException: {}", e.getMessage());
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                HttpStatus.NOT_FOUND.value(), e.getMessage()
        );
        return ResponseEntity
                .status(errorResponse.statusCode())
                .body(errorResponse);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidInputException(InvalidInputException e){
        log.error("InvalidInputException: {}", e.getMessage());
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                HttpStatus.BAD_REQUEST.value(), e.getMessage()
        );
        return ResponseEntity
                .status(errorResponse.statusCode())
                .body(errorResponse);
    }

}