package com.yazdi.projectManagementSystem.domain;

import com.yazdi.projectManagementSystem.domain.base.BaseEntity;
import com.yazdi.projectManagementSystem.enumiration.ProjectState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
public class Project extends BaseEntity {

    private String name;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime dueDate;

    private LocalDateTime finishDate;

    @Enumerated(STRING)
    private ProjectState state;

    @OneToMany(mappedBy = "project", cascade = REMOVE)
    private List<Task> tasks;

    @ManyToOne
    private User creator;

}