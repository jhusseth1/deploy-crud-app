package com.codingdojo.jhusseth.services.interfaces;

import com.codingdojo.jhusseth.domain.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    public boolean save(TaskDTO dto);

    public boolean update(TaskDTO dto);

    public boolean delete(Long userId, Long taskId);

    public TaskDTO findById(Long id);

    public List<TaskDTO> findAll(int order, Long userId);

    public List<TaskDTO> findAllByUserId(Long userId);


    public boolean isYourTask(Long userId, Long taskId);

    public boolean isValidAssignee(Long userId);


    public boolean completeTask(Long taskId);

}
