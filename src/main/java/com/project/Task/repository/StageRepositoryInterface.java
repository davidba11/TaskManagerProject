package com.project.Task.repository;

import com.project.Task.entity.Stages;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepositoryInterface {
    
    Optional<Stages> findByName(String name);
}
