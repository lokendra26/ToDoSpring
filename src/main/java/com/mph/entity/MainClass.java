package com.mph.entity;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class MainClass {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();	
		session.beginTransaction();
		
		Users user= new Users();
		user.setUserName("Lokendra malav");
		user.setEmailId("lokendramalav1999@gmail.com");
		user.setPassword("pass");
		user.setPhoneNumber(1234567890);
		
		Task task = new Task();
		task.setTaskName("Grocery");
		task.setTaskDate("18-08-2021");
		task.setTaskTime("03:49 PM");
		task.setTaskPriority(1);
		task.setTaskCategory("Food");
		task.setTaskStatus("Incomplete");
		task.setTaskRemainder("04:00 PM");
		task.setTaskDescription("Buy");
		task.setTaskLabel("Grocery");
		
		
		
		task.setUser(user);
		
		session.save(user);
		session.save(task);
		
		session.getTransaction().commit();
		
		System.out.println("TXN completed");
		
		
	}

}
