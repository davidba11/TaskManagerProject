package com.project.Task.repository;

import com.project.Task.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends JpaRepository<Users, Integer>{
//    @Query(value="SELECT id FROM USERS where username=username", nativeQuery = true)
//    Integer findUserByUsernameAndPass(String username);
    
    Users findByUsername(String username);
}
