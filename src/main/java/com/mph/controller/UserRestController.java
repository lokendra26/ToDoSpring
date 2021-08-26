package com.mph.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

import com.mph.entity.Task;
import com.mph.entity.Users;
import com.mph.service.UserService;
/*Lokendra*/

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins="http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserRestController {

	/*
	 * 
	 * 
	 * 
	 */
	@Autowired
	UserService userService;
	
	private static final Logger logger = Logger.getLogger(UserRestController.class);
	/*To get all the user details */
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> allUsers() {
		
		logger.info("GETTING REQUEST FROM CLIENT TO SHOW THE LIST OF UsersS");
		System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		//System.out.println(logger.getMessageFactory());
		
		PropertyConfigurator.configure(UserRestController.class.getClassLoader().getResource("log4j.properties"));
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Log4 j configuration is SUCCESSFUL");
		
		List<Users> userList = userService.getAllUser();
		System.out.println("From Rest allUser : " + userList);
		
		if(userList.isEmpty()) {
			
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(userList,HttpStatus.OK);		
		
	}
	/*To create a user  */
	@PostMapping("/createUser")
	public Users createUser(@RequestBody Users user) {
		userService.createUser(user);
		return user;
	}
	/*To get a user   */
	@PostMapping("/getUser")
	public ResponseEntity<Users> getUser(@RequestBody Users user) {
		Users usr = userService.getUser(user);
		System.out.println("From Rest getUser" +usr);
		if(usr==null) {
			return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Users>(usr,HttpStatus.OK); 
	}
	/*To update the user Details  */
	@PutMapping("/updateUser")
	//public ResponseEntity<List<Users>> updateUser(@RequestBody Users user) {
	public ResponseEntity<Users> updateUser(@RequestBody Users user) {

		//List<Users> usr = userService.updateUser(user);
		Users usr = userService.updateUser(user);
		System.out.println("From Rest update emp : " + usr);
		
		if(usr==null) {
			
			return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
			//return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		//return new ResponseEntity<List<Users>>(usr,HttpStatus.OK);		
		return new ResponseEntity<Users>(usr,HttpStatus.OK);
	}
	/*To retrieve user by using User EmailID  */
	@GetMapping("/getAUser/{emailId}/")
	public ResponseEntity<Users> getAUser(@PathVariable("emailId") String emailId) {
		
		logger.info("GETTING REQUEST FROM USER TO LOGIN");
		System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		//System.out.println(logger.getMessageFactory());
		
		PropertyConfigurator.configure(UserRestController.class.getClassLoader().getResource("log4j.properties"));
	PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Log4 j configuration is SUCCESSFUL");
		System.out.println("emailId: "+emailId );
		Users user =userService.getUserByEmailId(emailId);
		System.out.println("From Rest getUser : " + user);
		if(user == null) {
			return new ResponseEntity<Users>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Users>(user,HttpStatus.OK);		
		
		
	}
}
