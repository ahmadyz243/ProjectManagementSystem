package com.yazdi.projectManagementSystem.service.impl;

import com.yazdi.projectManagementSystem.domain.Task;
import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoSaveRequest;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoUpdateRequest;
import com.yazdi.projectManagementSystem.exception.EntityNotFoundException;
import com.yazdi.projectManagementSystem.exception.InvalidInputException;
import com.yazdi.projectManagementSystem.mapper.task.ITaskMapper;
import com.yazdi.projectManagementSystem.mapper.task.TaskMapper;
import com.yazdi.projectManagementSystem.repository.TaskRepository;
import com.yazdi.projectManagementSystem.service.IProjectService;
import com.yazdi.projectManagementSystem.service.ITaskService;
import com.yazdi.projectManagementSystem.service.IUserService;
import com.yazdi.projectManagementSystem.service.base.impl.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.yazdi.projectManagementSystem.enumiration.TaskState.IN_PROGRESS;

@Service
@Transactional
@Slf4j
public class TaskService extends BaseService<Task, TaskDto, TaskRepository>
    implements ITaskService {

    protected TaskService(TaskRepository repository, TaskMapper mapper, ITaskMapper taskMapper, IUserService userService, IProjectService projectService) {
        super(repository, mapper);
        this.taskMapper = taskMapper;
        this.userService = userService;
        this.projectService = projectService;
    }

    private final ITaskMapper taskMapper;
    private final IUserService userService;
    private final IProjectService projectService;


    @Override
    public TaskDto save(TaskDtoSaveRequest dto) {
        log.info("save; input: {}", dto);
        validateTaskDtoSaveRequest(dto);
        Task task = taskMapper.TaskDtoSaveRequestToEntity(dto);
        task.setCreateDate(LocalDateTime.now());
        task.setProgressPercentage(0);
        task.setState(IN_PROGRESS);
        task = repository.save(task);
        TaskDto result = mapper.entityToDto(task);
        log.info("save: result: {}", result);
        return result;
    }

    @Override
    public TaskDto update(TaskDtoUpdateRequest dto) {
        log.info("update; input: {}", dto);
        validateUpdateTask(dto);
        Task task = taskMapper.TaskDtoUpdateRequestToEntity(dto);
        task = repository.save(task);
        TaskDto result = mapper.entityToDto(task);
        log.info("update: output: {}", result);
        return result;
    }

    private void validateTaskDtoSaveRequest(TaskDtoSaveRequest dto){
        var now = LocalDateTime.now();
        var dueDate = dto.getDueDate();
        var projectId = dto.getProjectId();
        var creatorId = dto.getCreatorId();
        var assigneeId = dto.getAssigneeId();
        if(dueDate.isBefore(now)){
            log.error("dueDate can not be before now");
            throw new InvalidInputException("dueDate can not be before now");
        }
        if(projectId == null || projectId == 0){
            log.error("projectId can not be null or zero");
            throw new InvalidInputException("projectId can not be null or zero");
        }
        if(!projectService.existsById(projectId)){
            log.error("project not found with this id: {}", projectId);
            throw new EntityNotFoundException(String.format("project not found with this id: %d", projectId));
        }
        if(creatorId == null || creatorId == 0){
            log.error("creatorId can not be null or zero");
            throw new InvalidInputException("creatorId can not be null or zero");
        }
        if(!userService.existsById(creatorId)){
            log.error("creator not found with this id: {}", creatorId);
            throw new EntityNotFoundException(String.format("creator not found with this id: %d", creatorId));
        }
        if(assigneeId != null && assigneeId > 0 && !userService.existsById(assigneeId)){
            log.error("assignee not found with this id: {}", assigneeId);
            throw new EntityNotFoundException(String.format("assignee not found with this id: %d", assigneeId));
        }
    }

    private void validateUpdateTask(TaskDtoUpdateRequest dto){
        var now = LocalDateTime.now();
        var taskId = dto.getId();
        var dueDate = dto.getDueDate();
        var assigneeId = dto.getAssigneeId();
        if(taskId == null){
            log.error("field id can not be null");
            throw new InvalidInputException("field id can not be null");
        }
        if(!existsById(taskId)){
            log.error(String.format("task was not found with this id: %d", taskId));
            throw new EntityNotFoundException(String.format("task was not found with this id: %d", taskId));
        }
        if(dueDate.isBefore(now)){
            log.error("dueDate can not be before now");
            throw new InvalidInputException("dueDate can not be before now");
        }
        if(assigneeId != null && assigneeId > 0 && !userService.existsById(assigneeId)){
            log.error(String.format("assignee was not found with this id: %d", assigneeId));
            throw new EntityNotFoundException(String.format("assignee was not found with this id: %d", assigneeId));
        }
    }

}