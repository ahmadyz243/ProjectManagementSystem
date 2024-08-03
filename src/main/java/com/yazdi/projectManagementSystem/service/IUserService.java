package com.yazdi.projectManagementSystem.service;

import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.dto.user.UserDtoSaveRequest;
import com.yazdi.projectManagementSystem.service.base.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IBaseService<UserDto>, UserDetailsService {

    UserDto save(UserDtoSaveRequest dto);
    Long countUserAdmins();

}