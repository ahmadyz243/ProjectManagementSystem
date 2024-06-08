package com.yazdi.projectManagementSystem.controller;

import com.yazdi.projectManagementSystem.dto.project.ProjectDto;
import com.yazdi.projectManagementSystem.dto.project.ProjectDtoSaveRequest;
import com.yazdi.projectManagementSystem.service.IProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@Slf4j
@RequiredArgsConstructor
public class ProjectController {

    private final IProjectService service;


    @PostMapping("/save")
    public ResponseEntity<ProjectDto> save(@RequestBody ProjectDtoSaveRequest dto){
        log.info("save; input: {}", dto);
        ResponseEntity<ProjectDto> response = ResponseEntity.ok(
                service.save(dto)
        );
        log.debug("save; response: {}", response);
        return response;
    }

    @GetMapping("/getById/id={projectId}")
    public ResponseEntity<ProjectDto> getById(@PathVariable Long projectId){
        log.info("getById; input: {}", projectId);
        ResponseEntity<ProjectDto> response = ResponseEntity.ok(
                service.findById(projectId)
        );
        log.info("findById; response: {}", response);
        return response;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProjectDto>> getAll(){
        log.info("getAll invoked");
        ResponseEntity<List<ProjectDto>> response = ResponseEntity.ok(
                service.findAll()
        );
        log.info("getAll; response: {}", response);
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectDto dto){
        log.info("update; input: {}", dto);
        ResponseEntity<ProjectDto> response = ResponseEntity.ok(
                service.update(dto)
        );
        log.info("update: response: {}", response);
        return response;
    }

    @DeleteMapping("/deleteById/id={projectId}")
    public ResponseEntity<String> deleteById(@PathVariable Long projectId) {
        log.info("deleteById; input: {}", projectId);
        service.deleteById(projectId);
        ResponseEntity<String> response = ResponseEntity.ok("project deleted successfully");
        log.info("deleteById; response: {}", response);
        return response;
    }

}