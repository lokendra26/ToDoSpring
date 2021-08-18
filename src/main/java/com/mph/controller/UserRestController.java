package com.mph.controller;

import java.util.List;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mph.entity.User;
import com.mph.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins="http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserRestController {

	@Autowired
	UserService userService;
	
	//private static final Logger logger = Logger.getLogger(UserRestController.class);

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		userService.createUser(user);
		return user;
	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<List<User>> updateUser(@RequestBody User user) {
		
		List<User> userList = userService.updateUser(user);
		System.out.println("From Rest update emp : " + userList);
		
		if(userList.isEmpty()) {
			
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);		
		
	}
	
	@GetMapping("/getUser/{emailId}")
	public ResponseEntity<User> getAUser(@PathVariable("emailId") String emailId) {
		
		//logger.info("GETTING REQUEST FROM USER TO LOGIN");
		//System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		//System.out.println(logger.getMessageFactory());
		
		//PropertyConfigurator.configure(EmployeeRestController.class.getClassLoader().getResource("log4j.properties"));
		//PropertyConfigurator.configure("log4j.properties");
		
		//System.out.println("Log4 j configuration is SUCCESSFUL");
		
		User user =userService.getUserByEmailId(emailId);
		System.out.println("From Rest getEmp : " + user);
		if(user == null) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);		
		
		
	}
}
