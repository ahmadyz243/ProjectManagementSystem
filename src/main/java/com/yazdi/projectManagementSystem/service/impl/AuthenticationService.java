package com.yazdi.projectManagementSystem.service.impl;

import com.yazdi.projectManagementSystem.config.security.IJwtService;
import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.user.AuthenticationRequest;
import com.yazdi.projectManagementSystem.dto.user.AuthenticationResponse;
import com.yazdi.projectManagementSystem.dto.user.RegisterRequest;
import com.yazdi.projectManagementSystem.repository.UserRepository;
import com.yazdi.projectManagementSystem.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.yazdi.projectManagementSystem.enumiration.UserRole.DEVELOPER;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(DEVELOPER);
        userRepository.save(user);
        return new AuthenticationResponse(
                jwtService.generateToken(user)
        );
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        return new AuthenticationResponse(
                jwtService.generateToken(user)
        );
    }

}