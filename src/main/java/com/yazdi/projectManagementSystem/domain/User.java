package com.yazdi.projectManagementSystem.domain;

import com.yazdi.projectManagementSystem.domain.base.BaseEntity;
import com.yazdi.projectManagementSystem.enumiration.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@Table(name = "_User")
public class User extends BaseEntity {

    private String firstname;

    private String lastname;

    private String email;

    private String username;

    private String password;

    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "assignee")
    private List<Task> assignedTasks;

    @Enumerated(STRING)
    private UserRole role;

    @OneToMany(mappedBy = "creator")
    private List<Task> createdTasks = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Project> createdProjects = new ArrayList<>();

}