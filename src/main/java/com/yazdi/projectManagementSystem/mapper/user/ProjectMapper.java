package com.yazdi.projectManagementSystem.mapper.user;

import com.yazdi.projectManagementSystem.domain.Project;
import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.mapper.IMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper implements IMapper<Project, ProjectDto> {

    @Override
    public Project dtoToEntity(ProjectDto dto) {
        Project project = new Project();
        BeanUtils.copyProperties(dto, project);
        return project;
    }

    @Override
    public ProjectDto entityToDto(Project entity) {
        ProjectDto dto = new ProjectDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

}