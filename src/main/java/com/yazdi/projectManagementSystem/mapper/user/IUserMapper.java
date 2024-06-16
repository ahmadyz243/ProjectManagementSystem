package com.yazdi.projectManagementSystem.mapper.user;

import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.dto.user.UserDtoSaveRequest;
import com.yazdi.projectManagementSystem.mapper.IMapper;

public interface IUserMapper extends IMapper<User, UserDto> {

    UserDto UserDtoSaveRequestToUserDto(UserDtoSaveRequest dto);

}