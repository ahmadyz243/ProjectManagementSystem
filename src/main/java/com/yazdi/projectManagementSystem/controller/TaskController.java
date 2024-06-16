package com.yazdi.projectManagementSystem.controller;

import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoSaveRequest;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoUpdateRequest;
import com.yazdi.projectManagementSystem.service.ITaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@Slf4j
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService service;


    @PostMapping("/createTask")
    public ResponseEntity<TaskDto> createTask(TaskDtoSaveRequest dto){
        log.info("createTask; input: {}", dto);
        ResponseEntity<TaskDto> response = ResponseEntity.ok(service.save(dto));
        log.info("createTask; response: {}", response);
        return response;
    }

    @GetMapping("/findById/id={taskId}")
    public ResponseEntity<TaskDto> findById(@PathVariable Long taskId){
        log.info("findById; input: {}", taskId);
        ResponseEntity<TaskDto> response = ResponseEntity.ok(
                service.findById(taskId)
        );
        log.info("findById; response: {}", response);
        return response;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TaskDto>> findAll(){
        log.info("findAll invoked");
        ResponseEntity<List<TaskDto>> response = ResponseEntity.ok(
                service.findAll()
        );
        log.info("findAll; response: {}", response);
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<TaskDto> update(TaskDtoUpdateRequest dto){
        log.info("update; input: {}", dto);
        ResponseEntity<TaskDto> response = ResponseEntity.ok(
                service.update(dto)
        );
        log.info("update; response: {}", response);
        return response;
    }

    @DeleteMapping("/deleteById/id={taskId}")
    public ResponseEntity<String> deleteById(@PathVariable Integer taskId){
        log.info("deleteById; input: {}", taskId);
        ResponseEntity<String> response = ResponseEntity.ok(
                "task deleted successfully"
        );
        log.info("task deleted successfully");
        return response;
    }

}