package com.yazdi.projectManagementSystem.mapper.user;

import com.yazdi.projectManagementSystem.domain.Project;
import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.dto.user.UserDtoSaveRequest;
import com.yazdi.projectManagementSystem.mapper.project.IProjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements IUserMapper {
    public UserMapper(IProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    private final IProjectMapper projectMapper;


    @Override
    public User dtoToEntity(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }

    @Override
    public UserDto entityToDto(User entity) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(entity, dto);
        List<Project> createdProjects = entity.getCreatedProjects();
        List<ProjectDto> projectDtos = new ArrayList<>();
        if(createdProjects != null && !createdProjects.isEmpty())
            for(Project p: createdProjects)
                projectDtos.add(
                        projectMapper.entityToDto(p)
                );
        dto.setCreatedProjects(projectDtos);
        return dto;
    }

    @Override
    public UserDto UserDtoSaveRequestToUserDto(UserDtoSaveRequest dto) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(dto, userDto);
        return userDto;
    }

}