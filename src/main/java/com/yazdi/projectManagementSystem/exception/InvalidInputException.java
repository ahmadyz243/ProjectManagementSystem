package com.yazdi.projectManagementSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@AllArgsConstructor
@Getter
@Setter
public class InvalidInputException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 3L;
    private String message;

}