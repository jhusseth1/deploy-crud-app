package com.codingdojo.jhusseth.services.implementation;

import com.codingdojo.jhusseth.domain.dto.PriorityDTO;
import com.codingdojo.jhusseth.domain.mapper.PriorityMapper;
import com.codingdojo.jhusseth.repository.PriorityRepository;
import com.codingdojo.jhusseth.services.interfaces.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public List<PriorityDTO> findAll() {
        return priorityRepository.findAll().stream()
                .map(PriorityMapper.INSTANCE::priorityToPriorityDTO)
                .collect(Collectors.toList());
    }
}
