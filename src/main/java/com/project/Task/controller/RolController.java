package com.project.Task.controller;

import com.project.Task.entity.Roles;
import com.project.Task.service.RolService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolController {
    
    @Autowired
    private RolService rolService;
    
    @GetMapping(value="/{id}")
    public Optional<Roles> getRol(@PathVariable Integer id){
        return rolService.getRol(id);
    }
    
    @GetMapping(value="/{name}")
    public Optional<Roles> getRol(@PathVariable String name){
        return rolService.getRol(name);
    }
    
}
