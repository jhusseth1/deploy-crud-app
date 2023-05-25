package com.codingdojo.jhusseth.repository;

import com.codingdojo.jhusseth.domain.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
