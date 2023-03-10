package com.project.Task.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
