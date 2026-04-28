package org.bjm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author user
 */
@Controller
public class HomeController {
    
    @GetMapping(path = "/")
    public String getHome(){
        
        return "index";
    }
    
    @GetMapping(path = "/register")
    public String registerUser(){
        
        return "register/userRegister";
    }
    
    
    
}
