package com.codingdojo.jhusseth.repository;

import com.codingdojo.jhusseth.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskByIdAndCreatorUserId(Long id, Long userId);

    List<Task> findAllByCompleteOrderByPriorityIdDesc(boolean complete);

    List<Task> findAllByCompleteOrderByPriorityIdAsc(boolean complete);

    List<Task> findAllByCompleteIsFalse();

    List<Task> findAllByAssigneeUserIdOrderByPriorityIdAsc(Long userId);
}
