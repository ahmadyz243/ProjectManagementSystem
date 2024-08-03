package com.yazdi.projectManagementSystem.schedule;

import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static com.yazdi.projectManagementSystem.enumiration.UserRole.ADMIN;

@Component
@RequiredArgsConstructor
public class ApplicationStartup implements ApplicationRunner {

    private final IUserService userService;

    @Override
    public void run(ApplicationArguments args) {
        createDefaultAdminInThereIsNoAdmin();
    }

    private void createDefaultAdminInThereIsNoAdmin(){
        if(userService.countUserAdmins() == 0){
            userService.save(
                    new UserDto(
                            "admin"
                            , "admin"
                            , "ahmadyazdi243@gmail.com"
                            , "admin"
                            , "admin"
                            , ADMIN
                            , true
                            , false
                            , null
                            , null
                    )
            );
        }
    }

}