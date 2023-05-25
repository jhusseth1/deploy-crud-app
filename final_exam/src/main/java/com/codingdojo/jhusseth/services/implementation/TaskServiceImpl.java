package com.codingdojo.jhusseth.services.implementation;

import com.codingdojo.jhusseth.domain.dto.TaskDTO;
import com.codingdojo.jhusseth.domain.mapper.TaskMapper;
import com.codingdojo.jhusseth.domain.model.Priority;
import com.codingdojo.jhusseth.domain.model.Task;
import com.codingdojo.jhusseth.domain.model.User;
import com.codingdojo.jhusseth.repository.PriorityRepository;
import com.codingdojo.jhusseth.repository.TaskRepository;
import com.codingdojo.jhusseth.repository.UserRepository;
import com.codingdojo.jhusseth.services.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository repository;

    private static boolean validateTaskUser(User userAsg) {
        return userAsg.getAssigneeTask().stream()
                .filter(task -> !task.isComplete())
                .count() < 3;
    }

    @Override
    public boolean save(TaskDTO dto) {
        Task entity = TaskMapper.INSTANCE.taskDtoTotask(dto);
        if (Objects.nonNull(entity)) {
            Optional<User> userCreate = userRepository.findById(dto.getCreatorUserId());
            Optional<User> userAssignee = userRepository.findById(dto.getAssigneeUserId());
            Optional<Priority> optionalPriority = priorityRepository.findById(dto.getPriorityId());
            if (userCreate.isPresent() && userAssignee.isPresent() && optionalPriority.isPresent()) {
                User userCt = userCreate.get();
                User userAsg = userAssignee.get();
                Priority priority = optionalPriority.get();
                if (validateTaskUser(userAsg)) {
                    entity.setAssigneeUser(userAsg);
                    entity.setCreatorUser(userCt);
                    entity.setPriority(priority);
                    repository.save(entity);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean update(TaskDTO dto) {
        Optional<Task> task = repository.findById(dto.getId());
        if (task.isPresent()) {
            Task entity = task.get();
            if (!Objects.equals(entity.getAssigneeUser().getId(), dto.getAssigneeUserId())) {
                if (!isValidAssignee(dto.getAssigneeUserId())) {
                    return false;
                } else {
                    return save(dto);
                }
            } else {
                Optional<User> userAssignee = userRepository.findById(dto.getAssigneeUserId());
                Optional<Priority> optionalPriority = priorityRepository.findById(dto.getPriorityId());
                if (userAssignee.isPresent() && optionalPriority.isPresent()) {
                    entity.setName(dto.getName());
                    entity.setPriority(optionalPriority.get());
                    entity.setAssigneeUser(userAssignee.get());
                    repository.save(entity);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(Long userId, Long taskId) {
        Optional<User> user = userRepository.findById(userId);
        Optional<Task> task = repository.findById(taskId);

        boolean isValid = user.isPresent() && task.isPresent() && isYourTask(userId, taskId);
        if (isValid) {
            repository.deleteById(taskId);
            return true;
        }
        return false;
    }

    @Override
    public TaskDTO findById(Long id) {
        return repository.findById(id).map(TaskMapper.INSTANCE::taskToTaskDTO).orElse(null);
    }

    @Override
    public List<TaskDTO> findAll(int order, Long userId) {
        if (order == 1) {
            return repository.findAllByCompleteOrderByPriorityIdAsc(false).stream()
                    .filter(task -> !Objects.equals(task.getAssigneeUser().getId(), userId))
                    .map(TaskMapper.INSTANCE::taskToTaskDTO)
                    .collect(Collectors.toList());
        } else if (order == 2) {
            return repository.findAllByCompleteOrderByPriorityIdDesc(false).stream()
                    .filter(task -> !Objects.equals(task.getAssigneeUser().getId(), userId))
                    .map(TaskMapper.INSTANCE::taskToTaskDTO)
                    .collect(Collectors.toList());
        } else {
            return repository.findAllByCompleteIsFalse().stream()
                    .filter(task -> !Objects.equals(task.getAssigneeUser().getId(), userId))
                    .map(TaskMapper.INSTANCE::taskToTaskDTO)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<TaskDTO> findAllByUserId(Long userId) {
        return repository.findAllByAssigneeUserIdOrderByPriorityIdAsc(userId).stream()
                .map(TaskMapper.INSTANCE::taskToTaskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isYourTask(Long userId, Long taskId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        Optional<Task> optionalTask = repository.findById(taskId);
        boolean isValid = optionalUser.isPresent() && optionalTask.isPresent();
        Optional<Task> hasTask = repository.findTaskByIdAndCreatorUserId(taskId, userId);
        return isValid && hasTask.isPresent();
    }

    @Override
    public boolean isValidAssignee(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.filter(TaskServiceImpl::validateTaskUser).isPresent();
    }

    @Override
    public boolean completeTask(Long taskId) {
        Optional<Task> optionalTask = repository.findById(taskId);
        if (optionalTask.isPresent()) {
            Task entity = optionalTask.get();
            entity.setComplete(true);
            repository.save(entity);
            return true;
        }
        return false;
    }


}
