package com.yazdi.projectManagementSystem.dto.project;

import com.yazdi.projectManagementSystem.dto.base.BaseDto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectDtoSaveRequest extends BaseDto {

    private String name;

    private String title;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime dueDate;

    private Long creatorId;

}