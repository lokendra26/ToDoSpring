package com.mph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.mph.entity.Task;
import com.mph.entity.Users;
import com.mph.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;
	
	Task task;
	Users user;
	
	@RequestMapping(value = "/home",method = RequestMethod.POST)
	public ModelAndView afterSignin(@RequestParam("txtemail") String email,@RequestParam("txtpassword") String password )
	{
		user = new Users();
		
		user.setEmailId(email);
		user.setPassword(password);
		//Employee emp = employeeService.getEmployee(employee);
		return null;
					
	}
}
