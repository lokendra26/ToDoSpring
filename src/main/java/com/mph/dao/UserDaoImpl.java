package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;


import com.mph.entity.Users;

public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void createUser(Users user) {
		getSession().saveOrUpdate(user);
		System.out.println("User stored Successfully in DB !!!");
		
	}

	@Override
	public Users getUser(Users user) {
		Criteria c = getSession().createCriteria(Users.class);
		c.add(Restrictions.eq("email", user.getEmailId()));
		Users users = (Users)c.uniqueResult();
		System.out.println("Employee Retrieved : " + users);
		return users; 
	}

	@Override
	public Users updateUser(Users user) {
		Query query = getSession().createQuery("update Employee emp set userName=:userName,password=:password,phoneNumber=:phoneNumber where emailId=:email");
		query.setParameter("userName", user.getUserName());
		query.setParameter("password",user.getPassword());
		query.setParameter("phoneNumber",user.getPhoneNumber());
		query.setParameter("email", user.getEmailId());
		
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		
		return getUser(user);
	}

	@Override
	public Users getUserByEmailId(String emailId) {
		 Criteria c = getSession().createCriteria (Users.class);
	        c.add(Restrictions.eq("eid",emailId));
	        Users u= (Users)c.uniqueResult(); 
	        System.out.println("User Retrieved" + u);
	        return u;
	}
}
