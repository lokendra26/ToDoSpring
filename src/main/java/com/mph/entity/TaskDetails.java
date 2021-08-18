package com.mph.entity;

public class TaskDetails {
	
	private String taskCategory;
	private String taskStatus;
	private String taskRemainder;
	private String taskDescription;
	private String taskLabel;
	public TaskDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaskDetails(String taskCategory, String taskStatus, String taskRemainder, String taskDescription,
			String taskLabel) {
		super();
		this.taskCategory = taskCategory;
		this.taskStatus = taskStatus;
		this.taskRemainder = taskRemainder;
		this.taskDescription = taskDescription;
		this.taskLabel = taskLabel;
	}
	public String getTaskCategory() {
		return taskCategory;
	}
	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskRemainder() {
		return taskRemainder;
	}
	public void setTaskRemainder(String taskRemainder) {
		this.taskRemainder = taskRemainder;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskLabel() {
		return taskLabel;
	}
	public void setTaskLabel(String taskLabel) {
		this.taskLabel = taskLabel;
	}
	@Override
	public String toString() {
		return "TaskDetails [taskCategory=" + taskCategory + ", taskStatus=" + taskStatus + ", taskRemainder="
				+ taskRemainder + ", taskDescription=" + taskDescription + ", taskLabel=" + taskLabel + "]";
	}
	
	

}
