package com.yazdi.projectManagementSystem.service.impl;

import com.yazdi.projectManagementSystem.domain.User;
import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.dto.user.UserDtoSaveRequest;
import com.yazdi.projectManagementSystem.mapper.user.IUserMapper;
import com.yazdi.projectManagementSystem.mapper.user.UserMapper;
import com.yazdi.projectManagementSystem.repository.UserRepository;
import com.yazdi.projectManagementSystem.service.IUserService;
import com.yazdi.projectManagementSystem.service.base.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserService extends BaseService<User, UserDto, UserRepository>
        implements IUserService {

    protected UserService(UserRepository repository, UserMapper mapper, IUserMapper userMapper) {
        super(repository, mapper);
        this.userMapper = userMapper;
    }

    private final IUserMapper userMapper;


    @Override
    public UserDto save(UserDtoSaveRequest dto) {
        log.info("save; input: {}", dto);
        UserDto result = userMapper.UserDtoSaveRequestToUserDto(dto);
        result = super.save(result);
        log.info("save: output: {}", result);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        log.info("deleteById; input: {}", id);
        var user = super.findById(id);
        user.setIsDeleted(true);
        super.update(user);
        log.info("user deleted successfully");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = repository.findByUsername(username);
        User user = userOptional.orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format("User not found with username: %s", username)
                )
        );
        return user;
    }

}