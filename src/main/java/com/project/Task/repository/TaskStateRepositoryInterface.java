package com.project.Task.repository;

import com.project.Task.entity.TasksStates;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStateRepositoryInterface {
    
    Optional<TasksStates> findByName(String name);
    
}
