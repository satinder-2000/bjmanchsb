package org.bjm.controllers;

import org.bjm.LoginException;
import org.bjm.dtos.LoginDto;
import org.bjm.services.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	private LoginDto loginDto;
	boolean isUserLoggedIn;
	
	@Autowired
	private AccessService accessService;
	
	@GetMapping("/login")
	public ModelAndView showLoginForm() {
		ModelAndView modelAndView= new ModelAndView("login");
		LoginDto loginDto = new LoginDto();
		modelAndView.addObject("loginDto",loginDto);
		return modelAndView;
	}
	
	@PostMapping("/performLogin")
	public ModelAndView performLogin(@Valid @ModelAttribute("loginDto") LoginDto loginDto, HttpSession session ) {
		try {
			boolean status=accessService.performLogin(loginDto.getEmail(), loginDto.getPassword());
			if(status) {//successful login
				session.setAttribute("isUserLoggedIn", true);
			}
			ModelAndView modelAndView = new ModelAndView("userHome");
			modelAndView.addObject("loginDto", loginDto);
			return modelAndView;
		}catch(LoginException ex) {
			ModelAndView modelAndView = new ModelAndView("error");
			modelAndView.addObject("message", ex.getMessage());
			return modelAndView;
		}
	}

}
