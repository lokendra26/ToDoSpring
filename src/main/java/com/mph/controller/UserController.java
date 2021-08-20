package com.mph.controller;

import java.util.ArrayList;
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
			@RequestParam("txtphn") String phonenum)
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
	public ModelAndView allUsers()
	{
		List<Users> userlist = userService.getAllUser();
		//Users user = userService.getUser(user);
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("elist", userlist);	
		
	}
	@RequestMapping(value = "/home",method = RequestMethod.POST)
	public ModelAndView afterSignin(@RequestParam("txtemail") String email,@RequestParam("txtpassword") String password )
	{
		user = new Users();
		
		user.setEmailId(email);
		user.setPassword(password);
		List<Users> users = userService.getAllUser();
		if(users==null) {
			
			ModelAndView mv = new ModelAndView("login");
			return mv.addObject("NOTIFICATION", "Invalid Login / Password ");	
		}else {
		
			//return allUsers();
		return getUser(user);
		}
	}
	
	private ModelAndView getUser(Users user) {
		List<Users> userList = new ArrayList<Users>();
		Users users = userService.getUser(user);
		userList.add(users);
		ModelAndView mv = new ModelAndView("home");
		return mv.addObject("elist", userList);	
		
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(Users user)
	{
		return new ModelAndView("edit");		
	}
	
	@RequestMapping(value="/updateuser",method = RequestMethod.GET)
	public ModelAndView update(@ModelAttribute Users user)
	{
		List<Users> userList = new ArrayList<>();
		//List<Users> usr = userService.updateUser(user);
		Users usr = userService.updateUser(user);
		userList.add(usr);
		ModelAndView mv=new ModelAndView("home");
		return mv.addObject("elist",userList);
	}
		
}
