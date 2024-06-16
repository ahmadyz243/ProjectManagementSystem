package com.yazdi.projectManagementSystem.dto.task;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskDtoSaveRequest extends BaseDto {

    private String title;

    private String description;

    private LocalDateTime dueDate;

    private Long projectId;

    private Long creatorId;

    private Long assigneeId;

}