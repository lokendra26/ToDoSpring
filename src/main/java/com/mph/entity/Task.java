package com.mph.entity;

public class Task {
	
	private int taskId;
	private String taskName;
	private String taskDate;
	private String taskTime;
	private int taskPriority;
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(int taskId, String taskName, String taskDate, String taskTime, int taskPriority) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskTime = taskTime;
		this.taskPriority = taskPriority;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDate() {
		return taskDate;
	}
	public void setTaskDate(String taskDate) {
		this.taskDate = taskDate;
	}
	public String getTaskTime() {
		return taskTime;
	}
	public void setTaskTime(String taskTime) {
		this.taskTime = taskTime;
	}
	public int getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(int taskPriority) {
		this.taskPriority = taskPriority;
	}
	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDate=" + taskDate + ", taskTime=" + taskTime
				+ ", taskPriority=" + taskPriority + "]";
	}
	
	
	
	

}
