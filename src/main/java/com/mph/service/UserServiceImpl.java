package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.UserDao;
import com.mph.entity.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createUser(Users user) {
		userDao.createUser(user);
	}

	@Override
	public Users getUser(Users user) {
		
		return userDao.getUser(user);
	}

	/*@Override
	public List<Users> updateUser(Users user) {
		
		return userDao.updateUser(user);
	}*/
	public Users updateUser(Users user) {
		
		return userDao.updateUser(user);
	}

	@Override
	public Users getUserByEmailId(String emailId) {
		
		return userDao.getUserByEmailId(emailId);
	}

	@Override
	public List<Users> getAllUser() {
		return userDao.getAllUser();
	}

}