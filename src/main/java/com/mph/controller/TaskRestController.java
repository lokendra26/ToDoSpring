package com.mph.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.mph.service.TaskService;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins="http://localhost:4200",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class TaskRestController {

	@Autowired
	TaskService taskService;
	
	private static final Logger logger = Logger.getLogger(TaskRestController.class);
	
	@GetMapping("/allTask")
	public ResponseEntity<List<Task>> allTask() {
		
		logger.info("GETTING REQUEST FROM CLIENT TO SHOW THE LIST OF Tasks");
		System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		//System.out.println(logger.getMessageFactory());
		
		PropertyConfigurator.configure(TaskRestController.class.getClassLoader().getResource("log4j.properties"));
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Log4 j configuration is SUCCESSFUL");
		
		List<Task> taskList = taskService.getAllTasks();
		System.out.println("From Rest allTask : " + taskList);
		
		if(taskList.isEmpty()) {
			
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);		
		
	}
	
	@PostMapping("/allTaskOfAUser")
	public ResponseEntity<List<Task>> allTaskOfAUser(@RequestBody Users user) {
		
		
		logger.info("GETTING REQUEST FROM CLIENT TO SHOW THE LIST OF TaskS");
		System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		//System.out.println(logger.getMessageFactory());
		
		PropertyConfigurator.configure(TaskRestController.class.getClassLoader().getResource("log4j.properties"));
		PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("Log4 j configuration is SUCCESSFUL");
		
		
		//List<Task> taskList = taskService.getAllTasks();
		//Users user = task.getUser();
		System.out.println("User "+user);
		List<Task> taskList = taskService.getAllTasksOfAUser(user);
		
		System.out.println("From Rest allTaskOfAUser : " + taskList);
		
		if(taskList.isEmpty()) {
			
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);		
		
	}
	
	@GetMapping("/allTaskByPriority")
	public ResponseEntity<List<Task>> allTaskByPriority(@RequestBody Users user) {
		
		//List<Task> taskList = taskService.getAllTasks();
		List<Task> taskList = taskService.sortTaskByPriority(user);
		System.out.println("From Rest allTaskByPriority : " + taskList);
		
		if(taskList.isEmpty()) {
			
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);		
		
	}
	
	@PostMapping("/createTask")
	public Task createTask(@RequestBody Task task) {
		taskService.createTask(task);
		return task;
	}
	
	@PutMapping("/updateTask")
	public ResponseEntity<List<Task>> updateTask(@RequestBody Task task) {
		
		List<Task> taskList = taskService.updateTask(task);
		System.out.println("From Rest update Task : " + taskList);
		
		if(taskList.isEmpty()) {
			
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);		
		
	}
	
	@DeleteMapping("/deleteTask/{taskId}")
	public ResponseEntity<List<Task>> deleteTask(@PathVariable("taskId") int taskId,@RequestBody Users user) throws Exception {
		
		List<Task> taskList = taskService.deleteTask(taskId,user);
		System.out.println("From Rest update task : " + taskList);
		
		if(taskList.isEmpty()) {
			
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);		
		
	}
	
	@GetMapping("/getTask/{taskId}")
	public ResponseEntity<Task> getATask(@PathVariable("taskId") int taskId) {
		
		Task task =taskService.getTaskById(taskId);
		System.out.println("From Rest getTask : " + task);
		if(task == null) {
			return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Task>(task,HttpStatus.OK);		
		
		
	}
	
	@GetMapping("/getTaskByName/{taskName}/")
	public ResponseEntity<List<Task>> getTaskByName(@PathVariable("taskName") String taskName,@RequestBody Users user) throws Exception {
		
		//List<Task> taskList = taskService.getAllTasks();
		List<Task> taskList = taskService.getTaskByName(taskName,user);
		System.out.println("From Rest allTaskByName : " + taskList);
		
		if(taskList.isEmpty()) {
			
			return new ResponseEntity<List<Task>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Task>>(taskList,HttpStatus.OK);				
	}
			
}
