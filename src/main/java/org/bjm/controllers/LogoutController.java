package org.bjm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public ModelAndView logoutUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session!=null) {
			session.invalidate();
		}
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
		
	}

}
