package com.yazdi.projectManagementSystem.service;

import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoSaveRequest;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoUpdateRequest;
import com.yazdi.projectManagementSystem.service.base.IBaseService;

public interface ITaskService extends IBaseService<TaskDto> {

    TaskDto save(TaskDtoSaveRequest dto);
    TaskDto update(TaskDtoUpdateRequest dto);

}