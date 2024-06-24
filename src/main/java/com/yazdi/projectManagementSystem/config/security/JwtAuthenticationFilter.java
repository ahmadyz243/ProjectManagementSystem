package com.yazdi.projectManagementSystem.config.security;

import com.yazdi.projectManagementSystem.service.IUserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final IJwtService jwtService;
    private final IUserService userService;


    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest req
            , @NonNull HttpServletResponse resp
            , @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final var authHeader = req.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(req, resp);
            return;
        }
        final var jwt = authHeader.substring(7);
        final var username = jwtService.extractUsername(jwt);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails user = userService.loadUserByUsername(username);
            if(jwtService.isTokenValid(jwt, user)){
                var authToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            }
        }
    }

}