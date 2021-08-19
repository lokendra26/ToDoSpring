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
		Query query = getSession().createQuery("from Task task");
		List<Task> tasklist = query.list();
		System.out.println(tasklist);
		return tasklist; 
		
	}

	/*@Override
	public Task getTask(Task task) {
		Criteria c = getSession().createCriteria(Task.class);
		//c.add(Restrictions.eq("email", task.getEmail()));
		Task em = (Task)c.uniqueResult();
		System.out.println("Task Retrieved : " + em);
		return em;
		
	}*/

	@Override
	public List<Task> updateTask(Task task) {
		return null;
	}

	@Override
	public List<Task> deleteTask(int taskNo) {
		Query query = getSession().createQuery("delete from Employee emp where taskId=:taskNo");
		query.setParameter("taskNo", taskNo);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		
		return getAllTasks();
	}

	@Override
	public Task getTaskById(int taskId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
