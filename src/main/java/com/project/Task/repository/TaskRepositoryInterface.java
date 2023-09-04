package com.project.Task.repository;

import com.project.Task.entity.Tasks;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepositoryInterface {
    
    Optional<Tasks> findByName(String name);
    
}
