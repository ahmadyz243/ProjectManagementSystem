package com.yazdi.projectManagementSystem.mapper.task;

import com.yazdi.projectManagementSystem.domain.Task;
import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoSaveRequest;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoUpdateRequest;
import com.yazdi.projectManagementSystem.mapper.IMapper;

public interface ITaskMapper extends IMapper<Task, TaskDto> {

    Task TaskDtoSaveRequestToEntity(TaskDtoSaveRequest saveRequest);
    Task TaskDtoUpdateRequestToEntity(TaskDtoUpdateRequest updateRequest);

}