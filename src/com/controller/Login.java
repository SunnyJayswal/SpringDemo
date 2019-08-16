package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Login {
	
	@RequestMapping(value="load.html",method=RequestMethod.GET)
	
	public ModelAndView load()
	{
		return new ModelAndView("Login");
	}
	
	@RequestMapping(value="login.html",method=RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request)
	{
		String Username=request.getParameter("un");
		String Password=request.getParameter("pwd");
	
		if(Username.equals("admin") && Password.equals("admin"))
		{
			return new ModelAndView("LoginWelcome");
		}
		else
		{
			return new ModelAndView("Login");
		}
		
		
		
	
	}

}
