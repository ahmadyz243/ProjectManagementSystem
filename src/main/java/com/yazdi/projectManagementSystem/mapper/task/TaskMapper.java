package com.yazdi.projectManagementSystem.mapper.task;

import com.yazdi.projectManagementSystem.domain.Task;
import com.yazdi.projectManagementSystem.dto.task.TaskDto;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoSaveRequest;
import com.yazdi.projectManagementSystem.dto.task.TaskDtoUpdateRequest;
import com.yazdi.projectManagementSystem.mapper.IMapper;
import com.yazdi.projectManagementSystem.repository.ProjectRepository;
import com.yazdi.projectManagementSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper implements ITaskMapper {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Task dtoToEntity(TaskDto taskDto) {
        Task task = new Task();
        BeanUtils.copyProperties(taskDto, task);
        task.setCreator(userRepository.findById(taskDto.getCreatorId()).get());
        task.setProject(projectRepository.findById(taskDto.getProjectId()).get());
        var assigneeId = taskDto.getAssigneeId();
        if(assigneeId != null && assigneeId > 0)
            task.setAssignee(userRepository.findById(assigneeId).get());
        return task;
    }

    @Override
    public TaskDto entityToDto(Task entity) {
        TaskDto result = new TaskDto();
        BeanUtils.copyProperties(entity, result);
        result.setCreatorId(entity.getCreator().getId());
        result.setProjectId(entity.getProject().getId());
        return result;
    }

    @Override
    public Task TaskDtoSaveRequestToEntity(TaskDtoSaveRequest saveRequest){
        Task task = new Task();
        BeanUtils.copyProperties(saveRequest, task);
        task.setProject(projectRepository.findById(saveRequest.getProjectId()).get());
        task.setCreator(userRepository.findById(saveRequest.getCreatorId()).get());
        var assigneeId = saveRequest.getAssigneeId();
        if(assigneeId != null && assigneeId > 0)
            task.setAssignee(userRepository.findById(assigneeId).get());
        return task;
    }

    @Override
    public Task TaskDtoUpdateRequestToEntity(TaskDtoUpdateRequest updateRequest) {
        Task task = new Task();
        BeanUtils.copyProperties(updateRequest, task);
        task.setAssignee(userRepository.findById(updateRequest.getAssigneeId()).get());
        return task;
    }

}