package com.codingdojo.jhusseth.domain.mapper;

import com.codingdojo.jhusseth.domain.dto.TaskDTO;
import com.codingdojo.jhusseth.domain.model.Task;
import lombok.Generated;

import java.util.Objects;

@Generated
public class TaskMapperImpl implements TaskMapper {


    @Override
    public TaskDTO taskToTaskDTO(Task entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return TaskDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .assigneeUsername(entity.getAssigneeUser().getUsername())
                .creatorUsername(entity.getCreatorUser().getUsername())
                .priorityCode(entity.getPriority().getCode())
                .creatorUserId(entity.getCreatorUser().getId())
                .assigneeUserId(entity.getAssigneeUser().getId())
                .priorityId(entity.getPriority().getId())
                .complete(entity.isComplete())
                .build();
    }

    @Override
    public Task taskDtoTotask(TaskDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return Task.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
