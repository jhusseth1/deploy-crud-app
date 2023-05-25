package com.codingdojo.jhusseth.domain.mapper;

import com.codingdojo.jhusseth.domain.dto.TaskDTO;
import com.codingdojo.jhusseth.domain.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO taskToTaskDTO(Task entity);

    Task taskDtoTotask(TaskDTO dto);

}
