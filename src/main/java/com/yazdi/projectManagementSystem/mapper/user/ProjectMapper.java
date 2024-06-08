package com.yazdi.projectManagementSystem.mapper.user;

import com.yazdi.projectManagementSystem.domain.Project;
import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.mapper.IMapper;
import com.yazdi.projectManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectMapper implements IMapper<Project, ProjectDto> {

    private final UserRepository userRepository;

    @Override
    public Project dtoToEntity(ProjectDto dto) {
        Project project = new Project();
        BeanUtils.copyProperties(dto, project);
        project.setCreator(userRepository.findById(dto.getCreatorId()).get());
        return project;
    }

    @Override
    public ProjectDto entityToDto(Project entity) {
        ProjectDto dto = new ProjectDto();
        BeanUtils.copyProperties(entity, dto);
        dto.setCreatorId(entity.getCreator().getId());
        return dto;
    }

}