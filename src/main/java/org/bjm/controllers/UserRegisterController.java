package org.bjm.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.UserDto;
import org.bjm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

/**
 *
 * @author user
 */
@RestController
public class UserRegisterController {
    
    private static final Logger LOGGER = LogManager.getLogger();
    private UserDto userDto;
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("/registerUser")
	public String registerUser(@Valid UserDto userDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "register/userRegister";
		}
		return "register/userRegisterConfirm";
	}
    
    @PostMapping("/registerUserConfirm")
	public String registerUserConfirm(@Valid UserDto userDto, BindingResult bindingResult) {
    	
		if (bindingResult.hasErrors()) {
			return "register/userRegister";
		}else {
			userService.registerUser(userDto);
		}
		//Process to register the User
		LOGGER.info("User Registered Successfully!!");
		return "register/userRegisterSuccess";
	}
    
    
    
}
