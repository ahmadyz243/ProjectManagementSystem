package com.yazdi.projectManagementSystem.domain;

import com.yazdi.projectManagementSystem.domain.base.BaseEntity;
import com.yazdi.projectManagementSystem.enumiration.TaskState;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
public class Task extends BaseEntity {

    private String title;

    private String description;

    private Integer progressPercentage;

    private LocalDateTime createDate;

    private LocalDateTime startDate;

    private LocalDateTime dueDate;

    private LocalDateTime finishDate;

    @Enumerated(STRING)
    private TaskState state;

    @ManyToOne
    private Project project;

    @ManyToOne
    private User creator;

}