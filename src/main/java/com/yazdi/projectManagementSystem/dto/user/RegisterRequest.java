package com.yazdi.projectManagementSystem.dto.user;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String firstname;

    private String lastname;

    private String email;

    private String username;

    private String password;

}