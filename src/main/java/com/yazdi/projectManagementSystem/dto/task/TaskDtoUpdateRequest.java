package com.yazdi.projectManagementSystem.dto.task;

import com.yazdi.projectManagementSystem.enumiration.TaskState;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskDtoUpdateRequest {

    private String title;

    private String description;

    private Integer progressPercentage;

    private LocalDateTime dueDate;

    private Long assigneeId;

    private TaskState state;

}