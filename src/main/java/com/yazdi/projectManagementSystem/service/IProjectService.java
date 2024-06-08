package com.yazdi.projectManagementSystem.service;

import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.dto.project.ProjectDtoSaveRequest;
import com.yazdi.projectManagementSystem.service.base.IBaseService;

public interface IProjectService extends IBaseService<ProjectDto> {

    ProjectDto save(ProjectDtoSaveRequest dto);

}