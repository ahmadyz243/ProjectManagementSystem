package com.yazdi.projectManagementSystem.config.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

public interface IJwtService {

    String extractUsername(String token);
    Claims extractAllClaims(String token);
    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);
    Date extractExpiration(String token);
    String generateToken(Map<String, Object> extraClaims, UserDetails user);
    String generateToken(UserDetails user);
    boolean isTokenValid(String token, UserDetails user);
    boolean isTokenExpired(String token);

}