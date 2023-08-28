package com.project.Task.repository;

import com.project.Task.entity.Roles;
import com.project.Task.entity.Users;
import java.util.Collection;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositoryInterface extends JpaRepository<Roles, Integer>{
    
    Optional<Roles> findByName(String name);
    
    Collection<Users> getUsers(Integer id);
    
}
