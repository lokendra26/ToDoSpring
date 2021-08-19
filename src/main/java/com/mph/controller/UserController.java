package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping(value = "/adduser",method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtname") String name,
			@RequestParam("txtemail") String email,
			@RequestParam("txtpwd") String password,
			@RequestParam("txtphn") int phonenum)
	{
		System.out.println(name + "  " + email +" "+password+" "+phonenum);
		user = new Users();
		user.setUserName(name);
		user.setEmailId(email);
		user.setPassword(password);
		user.setPhoneNumber(phonenum);
		userService.createUser(user);
		
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value="/update",method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Users user)
	{
		List<Users> userlist = userService.updateUser(user);
		ModelAndView mv=new ModelAndView("home");
		return mv.addObject("elist",userlist);
	}
		
}
