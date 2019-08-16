package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller


public class Hello {
	
    @RequestMapping(value="Hello.html",method=RequestMethod.GET)
    
    public ModelAndView insert()
    {
    	String s1="HelloWorld";
    	return new ModelAndView("Hello","abc",s1);
    }

}
