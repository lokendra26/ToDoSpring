package com.mph.exception;

/*Lavanya*/
public class TaskNotFoundException extends Exception{

	//An exception class as user-defined 
	public TaskNotFoundException(){
		System.out.println("Task Not Found Exception thrown");
	}
	@Override
	public String toString() {
		return "Task Not Found Exception Raised";
	}
}
