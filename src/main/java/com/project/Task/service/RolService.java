package com.project.Task.service;

import com.project.Task.entity.Roles;
import com.project.Task.entity.Users;
import com.project.Task.repository.RolRepositoryInterface;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService{
    
    @Autowired
    private RolRepositoryInterface rolRepo;
    
    public Optional<Roles> getRol(Integer id) {
        return rolRepo.findById(id);
    }
    
    public Optional<Roles> getRol(String name) {
        return rolRepo.findByName(name);
    }
    
    public Collection<Users> getUsers(Integer id) {
        return rolRepo.getUsers(id);
    }
    
}
