package com.mph.exception;

public class TaskNotFoundException extends Exception{

	public TaskNotFoundException(){
		System.out.println("Task Not Found Exception thrown");
	}
	@Override
	public String toString() {
		return "Task Not Found Exception Raised";
	}
}
