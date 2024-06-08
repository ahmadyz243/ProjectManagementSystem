package com.yazdi.projectManagementSystem.dto.project;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.enumiration.ProjectState;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectDto extends BaseDto {

    private String name;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime dueDate;

    private LocalDateTime finishDate;

    private ProjectState state;

    private List<TaskDto> tasks = new ArrayList<>();

    private Long creatorId;

}