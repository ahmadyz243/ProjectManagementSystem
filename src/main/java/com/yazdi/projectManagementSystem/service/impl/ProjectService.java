package com.yazdi.projectManagementSystem.service.impl;

import com.yazdi.projectManagementSystem.domain.Project;
import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.dto.project.ProjectDtoSaveRequest;
import com.yazdi.projectManagementSystem.exception.EntityNotFoundException;
import com.yazdi.projectManagementSystem.exception.InvalidInputException;
import com.yazdi.projectManagementSystem.mapper.user.ProjectMapper;
import com.yazdi.projectManagementSystem.repository.ProjectRepository;
import com.yazdi.projectManagementSystem.service.IProjectService;
import com.yazdi.projectManagementSystem.service.IUserService;
import com.yazdi.projectManagementSystem.service.base.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.yazdi.projectManagementSystem.enumiration.ProjectState.IN_PROGRESS;

@Service
@Transactional
@Slf4j
public class ProjectService extends BaseService<Project, ProjectDto, ProjectRepository>
        implements IProjectService {

    protected ProjectService(ProjectRepository repository, ProjectMapper mapper, IUserService userService) {
        super(repository, mapper);
        this.userService = userService;
    }

    private final IUserService userService;


    @Override
    public ProjectDto save(ProjectDtoSaveRequest dto) {
        log.info("save; input: {}", dto);
        validateProjectDtoSaveRequest(dto);
        Project project = new Project();
        BeanUtils.copyProperties(dto, project);
        project.setState(IN_PROGRESS);
        User user = new User();
        BeanUtils.copyProperties(userService.findById(dto.getCreatorId()), user);
        project.setCreator(user);
        user.getCreatedProjects().add(project);
        ProjectDto result = new ProjectDto();
        BeanUtils.copyProperties(repository.save(project), result);
        log.info("save; output: {}", result);
        return result;
    }

    @Override
    public ProjectDto update(ProjectDto dto) {
        validateUpdateRequest(dto);
        return super.update(dto);
    }

    private void validateProjectDtoSaveRequest(ProjectDtoSaveRequest dto){
        var startDate = dto.getStartDate();
        var dueDate = dto.getDueDate();
        if(dueDate.isBefore(startDate))
            throw new InvalidInputException("dueDate can not be before than startDate");
        if(!userService.existsById(dto.getCreatorId()))
            throw new EntityNotFoundException(
                    String.format("creator not found with this id: %d", dto.getCreatorId())
            );
    }

    private void validateUpdateRequest(ProjectDto dto){
        var startDate = dto.getStartDate();
        var dueDate = dto.getDueDate();
        if(dueDate.isBefore(startDate))
            throw new InvalidInputException("dueDate can not be before than startDate");
        if(!userService.existsById(dto.getCreatorId()))
            throw new EntityNotFoundException(
                    String.format("creator not found with this id: %d", dto.getCreatorId())
            );
    }

}