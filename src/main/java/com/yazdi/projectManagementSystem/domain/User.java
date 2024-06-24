package com.yazdi.projectManagementSystem.domain;

import com.yazdi.projectManagementSystem.domain.base.BaseEntity;
import com.yazdi.projectManagementSystem.enumiration.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@Table(name = "_User")
public class User extends BaseEntity implements UserDetails {

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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(role.name())
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}