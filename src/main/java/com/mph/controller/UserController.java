package com.mph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mph.entity.Users;
import com.mph.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	Users user;
	
	@RequestMapping(value = "/registerpage",method = RequestMethod.GET)
	public ModelAndView register()
	{
		return new ModelAndView("register");	// actual page name
		
	}
	
	@RequestMapping(value = "/loginpage",method = RequestMethod.GET)
	public ModelAndView signin()
	{
		return new ModelAndView("login");
		
	}
	@RequestMapping(value = "/addemployee",method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtname") String name,
			@RequestParam("txtemail") String email,
			@RequestParam("txtpwd") String password)
	{
		System.out.println(name + "  " + email +" "+password);
		user = new Users();
		
		userService.createUser(user);
		
		return new ModelAndView("login");
		
	}
	
}
