package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.TaskDao;
import com.mph.entity.Task;
import com.mph.entity.Users;
/*Lokendra*/
 
 /*This class is used to call the methods in the Task Dao implementation*/
@Service
@Transactional
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskDao taskDao;
	
	
	public TaskServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTask(Task task) {
		taskDao.createTask(task);
		
	}

	@Override
	public List<Task> getAllTasks() {
		
		return taskDao.getAllTasks();
	}

	/*@Override
	public Task getTask(Task task) {
		
		return taskDao.getTask(task);
	}*/

	@Override
	public List<Task> updateTask(Task task) {
		
		return taskDao.updateTask(task);
	}

	@Override
	public List<Task> deleteTask(int taskId,Users user) throws Exception {
		
		return taskDao.deleteTask(taskId,user);
	}

	@Override
	public Task getTaskById(int taskId) {
		
		return taskDao.getTaskById(taskId);
	}

	@Override
	public List<Task> getAllTasksOfAUser( Users user) {
		
		return taskDao.getAllTasksOfAUser(user);
	}

	@Override
	public List<Task> getTaskByName(String task,Users user) throws Exception {
		
		return taskDao.getTaskByName(task,user);
	}

	@Override
	public List<Task> sortTaskByPriority(Users user) {
		
		return taskDao.sortTaskByPriority(user);
	}

}
