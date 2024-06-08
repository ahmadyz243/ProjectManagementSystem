package com.yazdi.projectManagementSystem.service.impl;

import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.mapper.user.UserMapper;
import com.yazdi.projectManagementSystem.repository.UserRepository;
import com.yazdi.projectManagementSystem.service.IUserService;
import com.yazdi.projectManagementSystem.service.base.impl.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BaseService<User, UserDto, UserRepository>
        implements IUserService {

    protected UserService(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public void deleteById(Long id) {
        var user = super.findById(id);
        user.setIsDeleted(true);
        super.update(user);
    }

}