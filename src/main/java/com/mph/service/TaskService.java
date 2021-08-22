package com.mph.service;

import java.util.List;

import com.mph.entity.Task;
import com.mph.entity.Users;

public interface TaskService {

	public void createTask(Task task);

	public List<Task> getAllTasks();

	//public Task getTask(Task task);

	public List<Task> updateTask(Task task);

	public List<Task> deleteTask(int taskId);

	public Task getTaskById(int taskId);
	
	public List<Task> getAllTasksOfAUser( Users user);
	
	public List<Task> getTaskByName(String task,Users user);
	
	public List<Task> sortTaskByPriority(Users user);

}
