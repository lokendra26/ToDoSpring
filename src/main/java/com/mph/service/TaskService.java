package com.mph.service;

import java.util.List;

import com.mph.entity.Task;

public interface TaskService {

	public void createTask(Task task);

	public List<Task> getAllTasks();

	public Task getTask(Task task);

	public List<Task> updateTask(Task task);

	public List<Task> deleteTask(int taskId);

	public Task getTaskById(int taskId);
}
