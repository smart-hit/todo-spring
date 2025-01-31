package com.todo.myTodoManagement.login;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
    
	public String gotoWelcome(ModelMap model) {
		model.put("name",getLoggedinUsername());
		
		return "welcome";
	}
	private String getLoggedinUsername() {
		Authentication authenication=SecurityContextHolder.getContext().getAuthentication();
		return authenication.getName();
	}
	
	
}
