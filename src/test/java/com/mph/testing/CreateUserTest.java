package com.mph.testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import com.mph.controller.UserRestController;
import com.mph.dao.TaskDaoImpl;
import com.mph.dao.UserDao;
import com.mph.dao.UserDaoImpl;
import com.mph.entity.Task;
import com.mph.entity.Users;


public class CreateUserTest {

	@Autowired
	private ResponseEntity<Users> user;
	@Autowired
	Users users;
	@Autowired
	Task task;
	@Test
 	public void testUser() throws NullPointerException{
	
 	UserRestController uc=new UserRestController();
		
 	try {
 		System.out.println(user);
		
		 user = uc.getAUser("sowmi@gmail.com");
 	}catch(Exception e) {
 		System.out.println("User not captured");
 	}
		assertNull(user);
 		}
	@Test
	public void testTaskUser() throws SQLException{
		TaskDaoImpl ud = new TaskDaoImpl();
	
		try {
	 		System.out.println(task);
			
			 task = ud.getTaskById(100);
	 	}catch(Exception e) {
	 		System.out.println("Task not captured");
	 	}
			assertNull(task);
	 		}
	}


