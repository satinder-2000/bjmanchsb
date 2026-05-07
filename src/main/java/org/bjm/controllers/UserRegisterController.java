package org.bjm.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.UserDto;
import org.bjm.services.ReferenceDataService;
import org.bjm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    private ReferenceDataService referenceDataService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/registerUser")
    private ModelAndView registerUserForm() {
    	ModelAndView modelAndView = new ModelAndView("register/userRegister");
    	userDto=new UserDto();
    	userDto.setStateDtos(referenceDataService.getAllStates());
    	modelAndView.addObject("userDto", userDto);
    	return modelAndView;
    }
    
    
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
