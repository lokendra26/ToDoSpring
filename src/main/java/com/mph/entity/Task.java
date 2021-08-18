package com.mph.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task extends TaskDetails{
	
	@Id
	@GeneratedValue
	private int taskId;
	@Column
	private String taskName;
	@Column
	private String taskDate;
	@Column
	private String taskTime;
	@Column
	private int taskPriority;
	
	@ManyToOne
	@JoinColumn(name = "emailId",referencedColumnName = "emailId")
	private Users user;
	
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Task(int taskId, String taskName, String taskDate, String taskTime, int taskPriority, Users user) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDate = taskDate;
		this.taskTime = taskTime;
		this.taskPriority = taskPriority;
		this.user = user;
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
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDate=" + taskDate + ", taskTime=" + taskTime
				+ ", taskPriority=" + taskPriority + ", user=" + user + "]";
	}

	
	
	
	
	

}
