
package com.project.Task.viewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class RegisterController {
    @GetMapping("/menu")
    public String menu(){
        return "invisible/menu";
    }
}
