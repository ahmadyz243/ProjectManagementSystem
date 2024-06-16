package com.yazdi.projectManagementSystem.dto.user;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import com.yazdi.projectManagementSystem.enumiration.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDtoSaveRequest extends BaseDto {

    private String firstname;

    private String lastname;

    private String email;

    private String username;

    private String password;

    private UserRole role;

}