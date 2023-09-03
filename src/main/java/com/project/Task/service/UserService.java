package com.project.Task.service;

import com.project.Task.entity.Roles;
import com.project.Task.entity.Users;
import com.project.Task.repository.UserRepositoryInterface;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepositoryInterface usrRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Users insertAUser(Users usr) {
        if (usr.getPassword() != null) 
            usr.setPassword(encrypterPass(usr.getPassword()));
        return usrRepo.save(usr);
    }

    public Users updateAUser(Users usr) {
        return usrRepo.save(usr);
    }

    public List<Users> getUsers() {
        return usrRepo.findAll();
    }

    public Optional<Users> getUser(Integer id) {
        return usrRepo.findById(id);
    }

    public boolean existUserById(Integer id) {
        return usrRepo.existsById(id);
    }

    public void deleteUserById(Integer id) {
        usrRepo.deleteById(id);
    }

    public void deleteUser(Users usr) {
        usrRepo.delete(usr);
    }

    public String encrypterPass(String pass) {
        return encoder.encode(pass);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usrRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Oops!");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("BASIC"));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
    
//    public Collection<Roles> getRoles(Integer id) {
//        return usrRepo.getRoles(id);
//    }

}
