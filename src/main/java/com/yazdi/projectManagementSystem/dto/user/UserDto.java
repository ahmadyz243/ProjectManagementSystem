package com.yazdi.projectManagementSystem.dto.user;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.enumiration.UserRole;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto extends BaseDto {

    private String firstname;

    private String lastname;

    private String email;

    private String username;

    private String password;

    private UserRole role;

    private List<TaskDto> createdTasks = new ArrayList<>();

    private List<ProjectDto> createdProjects = new ArrayList<>();

}