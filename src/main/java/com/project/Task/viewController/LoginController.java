package com.project.Task.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    
    @GetMapping(value="/login")
    public String verLogin(){
        return "login";
    }
    
    @GetMapping("/register")
    public String register(){
        return "register";
    }
    
    @PostMapping("/menu")
    public String menu(){
        return "menu";
    }
}
