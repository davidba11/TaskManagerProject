package com.project.Task.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
    @GetMapping(value="/login")
    public String verLogin(@RequestParam(required=false) String error, ModelMap model){
        if(error!=null)
            model.put("error","Incorrect username or password ");
        return "login";
    }
    
    @GetMapping("/register")
    public String register(){
        return "register";
    }
}
