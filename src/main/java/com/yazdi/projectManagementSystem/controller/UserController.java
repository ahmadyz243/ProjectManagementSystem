package com.yazdi.projectManagementSystem.controller;

import com.yazdi.projectManagementSystem.dto.user.UserDto;
import com.yazdi.projectManagementSystem.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final IUserService service;


    @PostMapping("/save")
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto){
        log.info("save; input: {}", dto);
        dto = service.save(dto);
        ResponseEntity<UserDto> response = ResponseEntity.ok(dto);
        log.debug("save; response: {}", response);
        return response;
    }

    @GetMapping("/getById/id={userId}")
    public ResponseEntity<UserDto> getById(@PathVariable Long userId){
        log.info("getById; input: {}", userId);
        ResponseEntity<UserDto> response = ResponseEntity.ok(
                service.findById(userId)
        );
        log.info("findById; response: {}", response);
        return response;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserDto>> getAll(){
        log.info("getAll invoked");
        ResponseEntity<List<UserDto>> response = ResponseEntity.ok(
                service.findAll()
        );
        log.info("getAll; response: {}", response);
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto dto){
        log.info("update; input: {}", dto);
        ResponseEntity<UserDto> response = ResponseEntity.ok(
                service.update(dto)
        );
        log.info("update: response: {}", response);
        return response;
    }

    @DeleteMapping("/deleteById/id={userId}")
    public ResponseEntity<String> deleteById(@PathVariable Long userId) {
        log.info("deleteById; input: {}", userId);
        service.deleteById(userId);
        ResponseEntity<String> response = ResponseEntity.ok("user deleted successfully");
        log.info("deleteById; response: {}", response);
        return response;
    }

}