package com.codingdojo.jhusseth.domain.mapper;


import com.codingdojo.jhusseth.domain.dto.PriorityDTO;
import com.codingdojo.jhusseth.domain.model.Priority;
import lombok.Generated;

import java.util.Objects;

@Generated
public class PriorityMapperImpl implements PriorityMapper {

    @Override
    public PriorityDTO priorityToPriorityDTO(Priority entity) {
        if (Objects.isNull(entity)) {
            return null;
        }
        return PriorityDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .value(entity.getValue())
                .build();
    }

    @Override
    public Priority priorityDtoToPriority(PriorityDTO dto) {
        if (Objects.isNull(dto)) {
            return null;
        }
        return Priority.builder()
                .id(dto.getId())
                .code(dto.getCode())
                .value(dto.getValue())
                .build();
    }
}
