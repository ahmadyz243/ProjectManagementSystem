package com.yazdi.projectManagementSystem.controller;

import com.yazdi.projectManagementSystem.dto.user.AuthenticationRequest;
import com.yazdi.projectManagementSystem.dto.user.AuthenticationResponse;
import com.yazdi.projectManagementSystem.dto.user.RegisterRequest;
import com.yazdi.projectManagementSystem.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final IAuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest dto){
        return ResponseEntity.ok(
                authenticationService.register(dto)
        );
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest dto){
        return ResponseEntity.ok(
                authenticationService.authenticate(dto)
        );
    }

}