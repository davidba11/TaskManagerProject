package com.project.Task.controller;

import com.project.Task.entity.Users;
import com.project.Task.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService usrService;
    
    @PostMapping(consumes = {"application/json"})
    public Users insertAUser(@RequestBody Users usr){
        return usrService.insertAUser(usr);
    }
    
    @PutMapping(consumes = {"application/json"})
    public Users updateAUser(@RequestBody Users usr){
        return usrService.updateAUser(usr);
    }
    
    @GetMapping
    public List<Users> getUsers(){
        return usrService.getUsers();
    }
    
    @GetMapping(value="/{id}")
    public Optional<Users> getUser(@PathVariable Integer id){
        return usrService.getUser(id);
    }
    
    @GetMapping(value="/{username}")
    public Optional<Users> getUser(@PathVariable String username){
        return usrService.getUser(username);
    }
    
    @GetMapping(value="/exist/{id}")
    public boolean existUserById(@PathVariable Integer id){
        return usrService.existUserById(id);
    }
    
    @DeleteMapping(value="/{id}")
    public void deleteUserById(@PathVariable Integer id){
        usrService.deleteUserById(id);
    }
    
    @DeleteMapping(consumes = {"application/json"})
    public void deleteUser(@RequestBody Users usr){
        usrService.deleteUser(usr);
    }
}
