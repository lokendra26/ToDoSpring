package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import com.mph.entity.Task;

public class TaskDaoImpl implements TaskDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createTask(Task task) {
		getSession().saveOrUpdate(task);
		System.out.println("Task stored Successfully in DB !!!");	
	}

	@Override
	public List<Task> getAllTasks() {
		Query query = getSession().createQuery("from Employee emp");
		List<Task> tasklist = query.list();
		System.out.println(tasklist);
		return tasklist; 
		
	}

	@Override
	public Task getTask(Task task) {
		Criteria c = getSession().createCriteria(Task.class);
		//c.add(Restrictions.eq("email", task.getEmail()));
		Task em = (Task)c.uniqueResult();
		System.out.println("Employee Retrieved : " + em);
		return em;
		
	}

	@Override
	public List<Task> updateTask(Task task) {
		return null;
	}

	@Override
	public List<Task> deleteTask(int taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task getTaskById(int taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
