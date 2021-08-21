package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mph.entity.Task;

@Repository
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
		 c.add(Restrictions.eq("
		Task em = (Task)c.uniqueResult();
		System.out.println("Task Retrieved : " + em);
		return em;
		
	}*/

	@Override
	public List<Task> updateTask(Task task) {
		Query query = getSession().createQuery("update Task task set taskName=:taskName,taskDate=:taskDate,taskTime=:taskTime,taskPriority=:taskPriority,"
				+ "taskCategory=:taskCategory,taskStatus=:taskStatus,taskDescription=:taskDescription,taskRemainder=:taskRemainder where taskId=:taskId");
		query.setParameter("taskName", task.getTaskName());
		query.setParameter("taskDate", task.getTaskDate());
		query.setParameter("taskTime", task.getTaskTime());
		query.setParameter("taskPriority", task.getTaskPriority());
		query.setParameter("taskCategory", task.getTaskCategory());
		query.setParameter("taskStatus", task.getTaskStatus());
		query.setParameter("taskDescription", task.getTaskDescription());
		query.setParameter("taskRemainder", task.getTaskRemainder());
		query.setParameter("taskId", task.getTaskId());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		
		return getAllTasks();
	}

	@Override
	public List<Task> deleteTask(int taskNo) {
		Query query = getSession().createQuery("delete from Task task where taskId=:taskNo");
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
		 Criteria c = getSession().createCriteria (Task.class);
        c.add(Restrictions.eq("taskId",taskId));
        Task e= (Task)c.uniqueResult(); 
        System.out.println("Task Retrieved" + e);
        return e;
        
	}

	
}
