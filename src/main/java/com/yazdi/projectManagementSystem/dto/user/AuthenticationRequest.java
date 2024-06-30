package com.yazdi.projectManagementSystem.dto.user;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationRequest {

    private String username;

    private String password;

}