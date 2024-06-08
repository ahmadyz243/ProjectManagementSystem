package com.yazdi.projectManagementSystem.dto.task;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import com.yazdi.projectManagementSystem.enumiration.TaskState;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskDto extends BaseDto {

    private String title;

    private String description;

    private Integer progressPercentage;

    private LocalDateTime createDate;

    private LocalDateTime startDate;

    private LocalDateTime dueDate;

    private LocalDateTime finishDate;

    private TaskState state;

    private Long projectId;

    private Long creatorId;

}