package com.yazdi.projectManagementSystem.service;

import com.yazdi.projectManagementSystem.dto.user.AuthenticationRequest;
import com.yazdi.projectManagementSystem.dto.user.AuthenticationResponse;
import com.yazdi.projectManagementSystem.dto.user.RegisterRequest;

public interface IAuthenticationService {

    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

}