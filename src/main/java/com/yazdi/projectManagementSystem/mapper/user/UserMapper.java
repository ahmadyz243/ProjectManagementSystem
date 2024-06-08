package com.yazdi.projectManagementSystem.mapper.user;

import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.mapper.IMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IMapper<User, UserDto> {

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
        return dto;
    }

}