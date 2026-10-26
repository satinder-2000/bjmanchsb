package org.bjm.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bjm.dtos.AccessDto;
import org.bjm.entities.Access;
import org.bjm.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
public class UserAccessController {
	
	private static final Logger LOGGER = LogManager.getLogger();
	
	@Autowired
	private AccessService accessService;
	
	@GetMapping("/createUserAccess/{email}")
	public ModelAndView showAccessForm(@PathVariable("email") String email) {
		ModelAndView modelAndView= new ModelAndView("register/createUserAccess");
		AccessDto accessDto = new AccessDto();
		accessDto.setEmail(email);
		modelAndView.addObject("accessDto",accessDto);
		return modelAndView;
	}
	
	@PostMapping("/createUserAccess")
	public ModelAndView submitAccess(@Valid @ModelAttribute("accessDto") AccessDto accessDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
    		return new ModelAndView("register/createuserAccess");
    	}
		// Step 2: Validation passed.
		accessService.createUserPassword(accessDto);
		ModelAndView modelAndView =
                new ModelAndView("register/userAccessCreated");

        modelAndView.addObject("email", accessDto.getEmail());

        return modelAndView;
	}

}
