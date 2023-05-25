package com.codingdojo.jhusseth.domain.mapper;

import com.codingdojo.jhusseth.domain.dto.PriorityDTO;
import com.codingdojo.jhusseth.domain.model.Priority;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PriorityMapper {

    PriorityMapper INSTANCE = Mappers.getMapper(PriorityMapper.class);

    PriorityDTO priorityToPriorityDTO(Priority priority);

    Priority priorityDtoToPriority(PriorityDTO dto);


}
