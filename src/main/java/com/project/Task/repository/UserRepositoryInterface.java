package com.project.Task.repository;

import com.project.Task.entity.Roles;
import com.project.Task.entity.Users;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryInterface extends JpaRepository<Users, Integer>{
//    @Query(value="SELECT * FROM USERS where username=username", nativeQuery = true)
//    Users findUserByUsername(String username);
    
    Users findByUsername(String username);
    
//    Collection<Roles> getRoles(Integer id);
}
